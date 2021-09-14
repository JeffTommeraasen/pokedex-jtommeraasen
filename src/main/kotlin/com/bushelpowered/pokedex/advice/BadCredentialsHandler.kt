package com.bushelpowered.pokedex.advice

import com.bushelpowered.pokedex.resource.ResponseError
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

/**
 * Advice handler for {@link BadCredentialsException}
 */
@ControllerAdvice
@Order(1)
class BadCredentialsHandler {

    @ExceptionHandler(BadCredentialsException::class)
    fun handleBadCredentials(e: BadCredentialsException, request: WebRequest) : ResponseEntity<ResponseError> {
        val responseError = ResponseError(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(), e.message)
        return ResponseEntity<ResponseError>(responseError, HttpStatus.UNAUTHORIZED)
    }
}