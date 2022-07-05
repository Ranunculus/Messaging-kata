package com.challenge.messagekata.controller.request

import com.challenge.messagekata.domain.exception.UserNotProvided
import java.util.*
import javax.servlet.http.HttpServletRequest

fun HttpServletRequest.getUserId(): UUID {
    val userId = this.getHeader("X-Authorization") ?: throw UserNotProvided("User id should be provided")
    return try { UUID.fromString(userId) } catch (e: IllegalArgumentException) {
        throw UserNotProvided("Incorrect user id has been provided. Should be UUID")
    }
}


