package com.abdelmageed.ordering.config

import com.abdelmageed.ordering.model.entity.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleGeneralException(ex: Exception): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            message = ex.message ?: "An unexpected error occurred",
            errorCode = "GEN-500"
        )
        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(NullPointerException::class)
    fun handleNullPointerException(ex: NullPointerException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            message = "Null pointer exception occurred",
            errorCode = "NULL-400"
        )
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArgumentException(ex: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(
            status = HttpStatus.BAD_REQUEST.value(),
            message = ex.message ?: "Invalid argument provided",
            errorCode = "400"
        )
        return ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST)
    }
}
