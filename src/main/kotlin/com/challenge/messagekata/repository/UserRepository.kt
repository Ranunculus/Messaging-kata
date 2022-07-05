package com.challenge.messagekata.repository

import com.challenge.messagekata.repository.entity.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository: CrudRepository<User, UUID>