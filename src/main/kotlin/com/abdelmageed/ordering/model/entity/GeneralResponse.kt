package com.abdelmageed.ordering.model.entity

import org.springframework.http.HttpStatus

data class GeneralResponse(
    val response: Any? = null,
    val error: Any? = null
)
