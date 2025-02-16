package com.abdelmageed.ordering.controller

import com.abdelmageed.ordering.model.entity.OrderEntity
import com.abdelmageed.ordering.service.NotificationsService
import com.abdelmageed.ordering.service.OrdersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/api/v1/orders")
class OrdersController(
    private val ordersService: OrdersService
) {
    @PostMapping
    fun addOrder(@RequestBody orderEntity: OrderEntity): ResponseEntity<OrderEntity> {
        return ordersService.createOrder(orderEntity)
    }

    @GetMapping
    fun getAllOrders(): ResponseEntity<List<OrderEntity>> = ordersService.listOrders()
}