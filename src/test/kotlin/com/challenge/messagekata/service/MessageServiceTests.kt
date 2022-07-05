package com.challenge.messagekata.service

import com.challenge.messagekata.domain.exception.CantSendMessageToYourself
import com.challenge.messagekata.repository.MessageRepository
import com.challenge.messagekata.repository.entity.Message
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.mockk.*
import org.junit.jupiter.api.Test
import java.util.*

class MessageServiceTests {
    private val messageRepository: MessageRepository = mockk()
    private val messagingService: MessagingService = mockk()

    private val messageService: MessageService = MessageServiceImpl(messageRepository, messagingService)

    @Test
    fun `test send`() {
        val recipientId = UUID.randomUUID()
        val senderId = UUID.randomUUID()

        every { messageRepository.save(any()) } returns Message(body = "message itself", senderId = senderId, recipientId = recipientId)
        justRun { messagingService.send(any()) }

        messageService.send("message itself", senderId, recipientId)

        slot<Message>().let { slot ->
            verify(exactly = 1) {
                messageRepository.save(capture(slot))
            }

            with(slot.captured) {
                body shouldBe "message itself"
                senderId shouldBe senderId
                recipientId shouldBe recipientId
            }
        }
    }

    @Test
    fun `test validation error`() {
        justRun { messageRepository.save(any()) }
        justRun { messagingService.send(any()) }

        val senderId = UUID.randomUUID()

        shouldThrow<CantSendMessageToYourself> {
            messageService.send("message itself", senderId, senderId)
        }

    }

    // TODO: 5/07/22 additional tests for message service
}

