package com.abdelmageed.ordering.repository

import com.abdelmageed.ordering.model.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<OrderEntity, String>