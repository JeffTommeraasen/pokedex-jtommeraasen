package com.bushelpowered.pokedex.login

import com.bushelpowered.pokedex.configuration.security.JwtTokenUtil
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException
import javax.servlet.http.HttpServletResponse

@RestController
class LoginController(
    val authenticationManager: AuthenticationManager,
    val jwtTokenUtil: JwtTokenUtil) {

    companion object {
        val LOG = LoggerFactory.getLogger(LoginController::class.java)
    }

    @PostMapping("/v1/login")
    @ResponseBody
    fun login(@RequestBody userLogin: UserLogin, response: HttpServletResponse) : ResponseEntity<LoginResponse> {
        var auth: Authentication?
        try {
            auth =
                authenticationManager.authenticate(UsernamePasswordAuthenticationToken(userLogin.username, userLogin.password))
        } catch(e: BadCredentialsException) {
            LOG.error("Invalid credentials used for ulogin request=[" + userLogin + "], message=" + e.message, e)
            throw e
        }
        val userDetails: PokedexUserDetails = auth.principal as PokedexUserDetails
        val token: String = jwtTokenUtil.generateAccessToken(userDetails)
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, token).body(LoginResponse(userDetails))

    }
}