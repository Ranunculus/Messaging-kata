package com.challenge.messagekata.service

import com.challenge.messagekata.repository.UserRepository
import com.challenge.messagekata.repository.entity.User
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (
    private val userRepository: UserRepository
) : UserService {

    override fun create(name: String) {
        userRepository.save(User(name = name))
    }
}