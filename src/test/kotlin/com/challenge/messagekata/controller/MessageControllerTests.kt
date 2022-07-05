package com.challenge.messagekata.controller

import com.challenge.messagekata.service.MessageService
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(MessageController::class)
class MessageControllerTests {

    @MockBean
    private lateinit var messageService: MessageService

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `test successful send`() {
        val recipientId = UUID.randomUUID()
        val userId = UUID.randomUUID()
        mockMvc.perform(
            MockMvcRequestBuilders.post("/message/send")
                .param("body", "Some awesome message")
                .param("recipientId", recipientId.toString())
                .header("X-Authorization", userId)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        Mockito.verify(messageService).send("Some awesome message", userId, recipientId)
    }

    @Test
    fun `test user not found`() {
        val recipientId = UUID.randomUUID()

        mockMvc.perform(
            MockMvcRequestBuilders.post("/message/send")
                .param("body", "Some awesome message")
                .param("recipientId", recipientId.toString())
                .header("X-Authorization", "some invalid string")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().is4xxClientError).andReturn()
    }

    @Test
    fun `test findAllReceived`() {
        val userId = UUID.randomUUID()
        mockMvc.perform(
            MockMvcRequestBuilders.get("/message/find/received")
                .header("X-Authorization", userId)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        Mockito.verify(messageService).findAllReceived(userId)
    }

    @Test
    fun `test findAllSent`() {
        val userId = UUID.randomUUID()
        mockMvc.perform(
            MockMvcRequestBuilders.get("/message/find/sent")
                .header("X-Authorization", userId)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        Mockito.verify(messageService).findAllSent(userId)
    }

    @Test
    fun `test findReceivedBySender`() {
        val userId = UUID.randomUUID()
        val senderId = UUID.randomUUID()
        mockMvc.perform(
            MockMvcRequestBuilders.get("/message/find/receivedBy")
                .param("senderId", senderId.toString())
                .header("X-Authorization", userId)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk).andReturn()
        Mockito.verify(messageService).findAllReceivedBySenderId(userId, senderId)
    }

}