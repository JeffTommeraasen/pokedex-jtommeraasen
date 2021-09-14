package com.bushelpowered.pokedex.advice

import com.bushelpowered.pokedex.exceptions.ExistsException
import com.bushelpowered.pokedex.resource.ResponseError
import org.springframework.core.annotation.Order
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

/**
 * Advice handler for a {@link ExistsException}.
 */
@ControllerAdvice
@Order(2)
class ExistsExceptionHandler {

    @ExceptionHandler(ExistsException::class)
    fun handleExistsException(e:ExistsException, request:WebRequest) : ResponseEntity<ResponseError> {
        val responseError = ResponseError(e.status, e.status.value(), e.message)
        return ResponseEntity<ResponseError>(responseError, e.status)
    }
}