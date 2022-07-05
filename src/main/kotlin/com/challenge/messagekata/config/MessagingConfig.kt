package com.challenge.messagekata.config

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
class RabbitMQConfig(
    private val amqpAdmin: AmqpAdmin
) {

    @PostConstruct
    fun createQueues() {
        amqpAdmin.declareQueue(Queue("messages", true))
    }

}