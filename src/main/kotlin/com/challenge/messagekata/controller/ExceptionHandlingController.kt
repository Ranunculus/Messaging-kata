package com.challenge.messagekata.controller

import com.challenge.messagekata.domain.exception.CantSendMessageToYourself
import com.challenge.messagekata.domain.exception.UserNotProvided
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandlingController : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [UserNotProvided::class])
    fun handleUserNotProvided(e: UserNotProvided): ResponseEntity<String> {
        return ResponseEntity(
            e.message,
            HttpStatus.BAD_REQUEST
        )
    }

    @ExceptionHandler(value = [CantSendMessageToYourself::class])
    fun handleCantSendMessageToYourself(): ResponseEntity<String> {
        return ResponseEntity(
            "Sender id and Recipient Id can't be the same",
            HttpStatus.BAD_REQUEST
        )
    }
}