package com.bushelpowered.pokedex.advice

import com.bushelpowered.pokedex.resource.ResponseError
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
@Order(4)
class ExceptionHandler {

    @ExceptionHandler(Throwable::class)
    fun handleThrowable(e: Throwable, request: WebRequest) : ResponseEntity<ResponseError> {
        val responseError = ResponseError(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.message)
        return ResponseEntity<ResponseError>(responseError, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}