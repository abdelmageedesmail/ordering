package com.abdelmageed.ordering.service.impl

import com.abdelmageed.ordering.model.entity.OrderEntity
import com.abdelmageed.ordering.repository.OrderRepository
import com.abdelmageed.ordering.service.NotificationsService
import com.abdelmageed.ordering.service.OrdersService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class OrdersServiceImpl(
    private val orderRepository: OrderRepository,
    private val notificationsService: NotificationsService
) : OrdersService {
    override fun createOrder(orderEntity: OrderEntity): ResponseEntity<OrderEntity> {
        val save = orderRepository.save(orderEntity)
        notificationsService.getAllTokens().forEach {
            notificationsService.sendNotifications(
                it,
                "New Order from ${orderEntity.user_name}",
                "please note that ${orderEntity.note}"
            )
        }
        return ResponseEntity(save, HttpStatus.OK)
    }

    override fun listOrders(): ResponseEntity<List<OrderEntity>> {
        return ResponseEntity(orderRepository.findAll(), HttpStatus.OK)
    }
}