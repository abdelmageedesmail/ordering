package com.abdelmageed.ordering.service.impl

import com.abdelmageed.ordering.model.entity.FirebaseTokensEntity
import com.abdelmageed.ordering.model.entity.GeneralResponse
import com.abdelmageed.ordering.repository.NotificationRepository
import com.abdelmageed.ordering.service.NotificationsService
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class NotificationsServiceImpl(private val notificationRepository: NotificationRepository) : NotificationsService {
    override fun setTokens(firebaseTokensEntity: FirebaseTokensEntity): GeneralResponse {
        return GeneralResponse(
            response = notificationRepository.save(firebaseTokensEntity)
        )
    }

    override fun sendNotifications(token: String, title: String, body: String): String {
        var response = ""
        val notification = Notification.builder()
            .setTitle(title)
            .setBody(body)
            .build()
        val message = Message.builder()
            .setToken(token)
            .setNotification(notification)
            .build()

        try {
            FirebaseMessaging.getInstance().send(message)
            response = "message sent successfully"
        } catch (e: Exception) {
            e.printStackTrace()
            response = "Error sending message: ${e.message}"
        }
        return response
    }

    override fun getAllTokens(): List<String> {
        val tokens = mutableListOf<String>()
        notificationRepository.findAll().map {
            tokens.add(it.token)
        }
        return tokens
    }
}