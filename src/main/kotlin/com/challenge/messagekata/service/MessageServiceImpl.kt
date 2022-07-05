package com.challenge.messagekata.service

import com.challenge.messagekata.domain.validateSenderAndRecipient
import com.challenge.messagekata.repository.MessageRepository
import com.challenge.messagekata.repository.entity.Message
import org.springframework.stereotype.Service
import java.util.*

@Service
class MessageServiceImpl(
    private val messageRepository: MessageRepository,
    private val messagingService: MessagingService
) : MessageService {

    override fun send(message: String, senderId: UUID, recipientId: UUID) {
        validateSenderAndRecipient(senderId, recipientId)
        val messageEntity = Message(body = message, senderId = senderId, recipientId = recipientId)
        messageRepository.save(messageEntity)
        messagingService.send(messageEntity)
    }

    override fun findAllReceived(recipientId: UUID) = messageRepository.findAllByRecipientId(recipientId)

    override fun findAllSent(senderId: UUID) = messageRepository.findAllBySenderId(senderId)

    override fun findAllReceivedBySenderId(recipientId: UUID, senderId: UUID) = messageRepository.findAllByRecipientIdAndSenderId(recipientId, senderId)

}