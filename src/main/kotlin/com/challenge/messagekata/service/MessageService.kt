package com.challenge.messagekata.service

import com.challenge.messagekata.repository.entity.Message
import java.util.*

interface MessageService {

    fun send(message: String, senderId: UUID, recipientId: UUID)

    fun findAllReceived(recipientId: UUID) : List<Message>

    fun findAllSent(senderId: UUID) : List<Message>

    fun findAllReceivedBySenderId(recipientId: UUID, senderId: UUID) : List<Message>

}