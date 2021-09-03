package com.bushelpowered.pokedex.advice

import com.bushelpowered.pokedex.resource.ResponseError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class IllegalArgumentExceptionHandler {

    @ExceptionHandler(IllegalArgumentException::class)
    fun handle(e: IllegalArgumentException, request: WebRequest) : ResponseEntity<ResponseError> {
        println("Error=" + e.message + " " + e)
        return ResponseEntity<ResponseError>(ResponseError(HttpStatus.BAD_REQUEST, e.message), HttpStatus.BAD_REQUEST)
    }
}