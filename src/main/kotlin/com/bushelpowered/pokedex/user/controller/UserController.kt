package com.bushelpowered.pokedex.user.controller

import com.bushelpowered.pokedex.user.service.DefaultCreateUserService
import com.bushelpowered.pokedex.exceptions.ExistsException
import com.bushelpowered.pokedex.login.LoginController
import com.bushelpowered.pokedex.resource.ResponseError
import com.bushelpowered.pokedex.resource.User
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.*
import java.util.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@RestController
class UserController(val userService: DefaultCreateUserService) {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(LoginController::class.java)
    }

    @PutMapping(value=arrayOf("/v1/user"), consumes=arrayOf(MediaType.APPLICATION_JSON_VALUE), produces=arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun createUser(@RequestBody user: User): ResponseEntity<*> {
        assertInputParameter(user)
        user.uniqueId = UUID.randomUUID().toString()
        try {
            val user: User = userService.createUser(user)
        } catch(e:ExistsException) {
            LOG.error("A user record already exists with the supplied user information.", e)
            return ResponseEntity(ResponseError(e.status, e.status.value(), e.message), e.status)
        }
        return ResponseEntity(user, HttpStatus.OK)
    }

    fun assertInputParameter(user: User) {
        Assert.hasText(user.userId, "user id cannot be empty.")
        Assert.hasText(user.password, "user password cannot be empty.")
        Assert.hasText(user.email, "user email cannot be empty")
    }
}