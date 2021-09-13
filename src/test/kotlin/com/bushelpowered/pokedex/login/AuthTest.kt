package com.bushelpowered.pokedex.login

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class AuthTest {

    @BeforeEach
    fun beforeEach() {
        println("before...")
    }

    @Test
    fun test_encode() {
        val bcrypt: BCryptPasswordEncoder = BCryptPasswordEncoder()
        val encoded = bcrypt.encode("1234")
        println("encoded=[" + encoded + "]")
    }

}