package com.abdelmageed.ordering.repository

import com.abdelmageed.ordering.model.entity.FirebaseTokensEntity
import org.springframework.data.jpa.repository.JpaRepository

interface NotificationRepository : JpaRepository<FirebaseTokensEntity, String> {
}