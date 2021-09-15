package com.bushelpowered.pokedex.advice

import com.bushelpowered.pokedex.advice.ExceptionHandler.Companion.LOG
import com.bushelpowered.pokedex.exceptions.ExistsException
import com.bushelpowered.pokedex.exceptions.UserNotFoundException
import com.bushelpowered.pokedex.login.LoginController.Companion.LOG
import com.bushelpowered.pokedex.resource.ResponseError
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class ExceptionHandler {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(ExceptionHandler::class.java)
    }

    @ExceptionHandler(BadCredentialsException::class)
    fun handleBadCredentials(e: BadCredentialsException, request: WebRequest) : ResponseEntity<ResponseError> {
        LOG.error("handling BadCredentialsException=[" + e.message + "].", e)
        val responseError = ResponseError(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(), e.message)
        return ResponseEntity<ResponseError>(responseError, HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(ExistsException::class)
    fun handleExistsException(e: ExistsException, request:WebRequest) : ResponseEntity<ResponseError> {
        LOG.error("handling ExistsException=[" + e.message + "].", e)
        val responseError = ResponseError(e.status, e.status.value(), e.message)
        return ResponseEntity<ResponseError>(responseError, e.status)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handle(e: IllegalArgumentException, request: WebRequest) : ResponseEntity<ResponseError> {
        LOG.error("handling IllegalArgumentException=[" + e.message + "].", e)
        return ResponseEntity<ResponseError>(ResponseError(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), e.message), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun handle(e: UserNotFoundException, request: WebRequest) : ResponseEntity<ResponseError> {
        LOG.error("handling UserNotFoundException=[" + e.message + "].", e)
        return ResponseEntity<ResponseError>(ResponseError(HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value(), e.message), HttpStatus.UNAUTHORIZED)
    }
}