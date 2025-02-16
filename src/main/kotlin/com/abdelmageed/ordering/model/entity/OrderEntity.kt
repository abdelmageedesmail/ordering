package com.abdelmageed.ordering.model.entity

import jakarta.persistence.*

@Table(name = "orders")
@Entity
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_id_seq")
    @Column(name = "id", updatable = false, unique = true)
    val id: Int? = null,
    @Column(name = "user_name")
    val user_name: String = "",
    @Column(name = "order_content")
    val order_content: String = "",
    @Column(name = "status")
    val status: Int? = null,
    @Column(name = "note")
    val note: String? = null
)