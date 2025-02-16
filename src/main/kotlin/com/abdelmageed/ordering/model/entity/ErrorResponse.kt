package com.abdelmageed.ordering.model.entity

import java.text.SimpleDateFormat
import java.util.*

data class ErrorResponse(
    val status: Int,
    val message: String,
    val errorCode: String? = null,
    val timestamp: String = convertMillisToDate(System.currentTimeMillis())
)

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("MM/dd/yyyy hh:mm:ss", Locale.getDefault())
    return formatter.format(Date(millis))
}
