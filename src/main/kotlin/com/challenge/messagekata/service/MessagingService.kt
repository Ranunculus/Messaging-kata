package com.challenge.messagekata.service

import com.challenge.messagekata.repository.entity.Message

interface MessagingService {

    fun send(message: Message)
}