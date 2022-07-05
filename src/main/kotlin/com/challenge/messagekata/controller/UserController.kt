package com.challenge.messagekata.controller

import com.challenge.messagekata.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@Tag(name = "Handles user related requests")
@RestController
@RequestMapping(
    path = ["/user"],
    produces = [MediaType.APPLICATION_JSON_VALUE]
)
class UserController(
    private val userService: UserService
) {

    @PostMapping("/create")
    @Operation(
        operationId = "createUser",
        summary = "Create user with given name"
    )
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestParam name: String) = userService.create(name)
}