package com.bushelpowered.pokedex.account.controller

import com.bushelpowered.pokedex.account.service.DefaultUserService
import com.bushelpowered.pokedex.account.service.UserService
import com.bushelpowered.pokedex.exceptions.ExistsException
import com.bushelpowered.pokedex.resource.ResponseError
import com.bushelpowered.pokedex.resource.User
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.*
import java.util.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@RestController
@RequestMapping("/pokedex/v1")
@Slf4j
class AccountController(userService: DefaultUserService) {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)
    private val userService : UserService = userService

    @PutMapping(value=arrayOf("/account"), consumes=arrayOf(MediaType.APPLICATION_JSON_VALUE), produces=arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun createAccount(@RequestBody user: User): ResponseEntity<*> {
        assertInputParameter(user)
        println("DEBUG::user params asserted")
        user.uniqueId = UUID.randomUUID().toString()
        try {
            val user: User = userService.createUser(user)
        } catch(e:ExistsException) {
            log.error("exception=" + e .message, e)
            return ResponseEntity(ResponseError(e.status, e.message), e.status)
        }
        return ResponseEntity(user, HttpStatus.OK)
    }

    fun assertInputParameter(user: User) {
        Assert.hasText(user.userId, "user id cannot be empty.")
        Assert.hasText(user.password, "user password cannot be empty.")
        Assert.hasText(user.email, "user email cannot be empty")
    }
}