package com.challenge.messagekata.controller

import com.challenge.messagekata.controller.request.getUserId
import com.challenge.messagekata.service.MessageService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.HttpServletRequest


@Tag(name = "Handles message related requests")
@RestController
@RequestMapping(
    path = ["/message"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class MessageController(
    private val messageService: MessageService
) {

    @PostMapping("/send")
    @Operation(
        operationId = "sendMessage",
        summary = "Send massage to selected user"
    )
    fun sendMessage(request: HttpServletRequest,
                    @RequestParam body: String,
                    @RequestParam recipientId: UUID
    ) = messageService.send(body, request.getUserId(), recipientId)

    @GetMapping("/find/received")
    @Operation(
        operationId = "findAlReceived",
        summary = "Find all received messages by user"
    )
    fun findAllReceived(request: HttpServletRequest) = messageService.findAllReceived(request.getUserId())

    @GetMapping("/find/sent")
    @Operation(
        operationId = "findAllSent",
        summary = "Find all sent messages by user"
    )
    fun findAllSent(request: HttpServletRequest) = messageService.findAllSent(request.getUserId())


    @GetMapping("/find/receivedBy")
    @Operation(
        operationId = "findReceivedBySender",
        summary = "Find all sent messages by user"
    )
    fun findReceivedBySender(request: HttpServletRequest, @RequestParam senderId: UUID) = messageService.findAllReceivedBySenderId(request.getUserId(), senderId)


}