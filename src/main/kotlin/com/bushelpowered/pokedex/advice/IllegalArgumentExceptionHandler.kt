package com.bushelpowered.pokedex.advice

import com.bushelpowered.pokedex.resource.ResponseError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

/**
 * Advice handler for an {@link IllegalArgumentException}.
 */
@ControllerAdvice
class IllegalArgumentExceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handle(e: IllegalArgumentException, request: WebRequest) : ResponseEntity<ResponseError> {
        return ResponseEntity<ResponseError>(ResponseError(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), e.message), HttpStatus.BAD_REQUEST)
    }
}