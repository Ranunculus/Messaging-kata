package com.challenge.messagekata.domain

import com.challenge.messagekata.domain.exception.CantSendMessageToYourself
import java.util.*

fun validateSenderAndRecipient(senderId: UUID, recipientId: UUID) =
    if (senderId == recipientId) throw CantSendMessageToYourself() else {}