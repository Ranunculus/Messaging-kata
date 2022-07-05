package com.challenge.messagekata.repository

import com.challenge.messagekata.repository.entity.Message
import org.springframework.data.repository.CrudRepository
import java.util.*

interface MessageRepository: CrudRepository<Message, UUID> {

    fun findAllByRecipientId(recipientId: UUID) : List<Message>

    fun findAllBySenderId(senderId: UUID) : List<Message>

    fun findAllByRecipientIdAndSenderId(recipientId: UUID, senderId: UUID) : List<Message>
}