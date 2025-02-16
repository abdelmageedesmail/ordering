package com.abdelmageed.ordering.service

import com.abdelmageed.ordering.model.entity.OrderEntity
import org.springframework.http.ResponseEntity

interface OrdersService {
    fun createOrder(orderEntity: OrderEntity): ResponseEntity<OrderEntity>
    fun listOrders(): ResponseEntity<List<OrderEntity>>
}