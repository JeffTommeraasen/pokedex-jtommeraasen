package com.bushelpowered.pokedex.advice

import com.bushelpowered.pokedex.exceptions.ExistsException
import com.bushelpowered.pokedex.resource.ResponseError
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ExistsExceptionHandler {

    @ExceptionHandler(ExistsException::class)
    fun handleExistsException(e:ExistsException, request:WebRequest) : ResponseEntity<ResponseError> {
        val errorMessage: String? = e.message
        val responseError: ResponseError = ResponseError(e.status, e.message)
        return ResponseEntity<ResponseError>(responseError, e.status)
    }
}