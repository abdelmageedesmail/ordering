package com.abdelmageed.ordering.controller

import com.abdelmageed.ordering.model.entity.FirebaseTokensEntity
import com.abdelmageed.ordering.model.entity.GeneralResponse
import com.abdelmageed.ordering.service.NotificationsService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/notifications")
class NotificationController(private val notificationService: NotificationsService) {

    @PostMapping("/send")
    fun sendNotification(
        @RequestParam token: String,
        @RequestParam title: String,
        @RequestParam body: String
    ): String {
        return notificationService.sendNotifications(token, title, body)
    }

    @PostMapping("/tokens")
    fun setToken(@RequestBody tokensEntity: FirebaseTokensEntity): GeneralResponse {
        return notificationService.setTokens(tokensEntity)
    }
}