package com.challenge.messagekata.repository.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "`user`")
class User(

    @Id
    @GeneratedValue(generator = "UUID")
    val id: UUID? = null,

    val name: String

)