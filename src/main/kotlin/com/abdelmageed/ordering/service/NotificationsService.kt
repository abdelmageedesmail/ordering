package com.abdelmageed.ordering.service

import com.abdelmageed.ordering.model.entity.FirebaseTokensEntity
import com.abdelmageed.ordering.model.entity.GeneralResponse

interface NotificationsService {
    fun setTokens(firebaseTokensEntity: FirebaseTokensEntity): GeneralResponse
    fun sendNotifications(token: String, title: String, body: String): String
    fun getAllTokens(): List<String>
}