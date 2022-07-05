package com.challenge.messagekata.service

import com.challenge.messagekata.repository.UserRepository
import com.challenge.messagekata.repository.entity.User
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.jupiter.api.Test

class UserServiceTests {
    private val userRepository: UserRepository = mockk()

    private val userService: UserService = UserServiceImpl(userRepository)

    @Test
    fun `test create user`() {
        every { userRepository.save(any()) } returns User(name = "name")
        userService.create("name")

        slot<User>().let { slot ->
            verify(exactly = 1) {
                userRepository.save(capture(slot))
            }

            with(slot.captured) {
                name shouldBe "name"
            }
        }
    }
}

