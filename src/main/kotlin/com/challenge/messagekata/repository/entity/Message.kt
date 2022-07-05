package com.challenge.messagekata.repository.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "message")
class Message(
    @Id
    @GeneratedValue(generator = "UUID")
    val id: UUID? = null,

    val body: String,

    val recipientId: UUID,

    val senderId: UUID
) {
    override fun toString(): String {
        return "Message(body='$body', recipientId=$recipientId, senderId=$senderId)"
    }
}