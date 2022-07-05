package com.challenge.messagekata.service

import com.challenge.messagekata.repository.entity.Message
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class MessagingServiceImpl(
    private val messageTemplate: RabbitTemplate
) : MessagingService {

    override fun send(message: Message) {
        messageTemplate.convertAndSend("messages", message.toString())
    }

}