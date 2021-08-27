package com.bushelpowered.pokedex.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pokedex/v1")
class AccountController {
    // TODO - JT - update to add response object with implementation, including error handling.
    @PutMapping(value=arrayOf("/account"), consumes= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun createAccount() {

    }
}