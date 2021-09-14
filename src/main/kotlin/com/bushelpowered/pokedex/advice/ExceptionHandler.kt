package com.bushelpowered.pokedex.advice

import com.bushelpowered.pokedex.resource.ResponseError
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
@Order(4)
class ExceptionHandler {
    companion object {
        val LOG: Logger = LoggerFactory.getLogger(ExceptionHandler::class.java)
    }

    @ExceptionHandler(Throwable::class)
    fun handleThrowable(e: Throwable, request: WebRequest) : ResponseEntity<ResponseError> {
        LOG.error("An error occurred while processing the request, message=[" + e.message + "]", e)
        val responseError = ResponseError(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), e.message)
        return ResponseEntity<ResponseError>(responseError, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}