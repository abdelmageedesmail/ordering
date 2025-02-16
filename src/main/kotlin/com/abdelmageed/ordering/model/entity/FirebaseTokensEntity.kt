package com.abdelmageed.ordering.model.entity

import jakarta.persistence.*

@Table(name = "tokens")
@Entity
data class FirebaseTokensEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false, unique = true)
    val token: String,
    @Column
    val platform: String?
)