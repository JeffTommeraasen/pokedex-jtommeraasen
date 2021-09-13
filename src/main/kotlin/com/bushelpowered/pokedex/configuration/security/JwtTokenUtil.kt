package com.bushelpowered.pokedex.configuration.security

import com.bushelpowered.pokedex.login.LoginUserDetails
import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenUtil (
    @Value("\${jwt.passkey:}")
    val passkey : String,
    @Value("\${jwt.issuer:}")
    val issuer : String,
    val mapper : ObjectMapper) {

    companion object {
        val defaultKey = "xZ6MtNx5TedtR3ncmRb"
        val defaultIssuer = "pokedex"
        val LOGGER = LoggerFactory.getLogger(JwtTokenUtil::class.java)
    }

    private fun resolvePasskey(): String {
        return passkey.ifBlank { defaultKey }
    }

    private fun resolveIssuer(): String {
        return issuer.ifBlank { defaultIssuer }
    }

    fun validate(token: String?): Boolean {
        return try {
            Jwts.parser().setSigningKey(this.resolvePasskey()).parseClaimsJws(token)
            true
        } catch (e: Throwable) {
            LOGGER.info("Error occurred during validation, message=[" + e.message + "].", e)
            false
        }
    }

    fun generateAccessToken(loginUserDetails: LoginUserDetails): String {
        return Jwts.builder()
            .setSubject(mapper.writeValueAsString(AuthenticatedUser(loginUserDetails)))
            .setIssuer(this.resolveIssuer())
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))
            .signWith(SignatureAlgorithm.HS512, this.resolvePasskey())
            .compact()
    }

    fun getUsername(token: String): String? {
        return mapper.readValue(Jwts.parser()
            .setSigningKey(this.resolvePasskey())
            .parseClaimsJws(token)
            .body.subject, AuthenticatedUser::class.java).username
    }

    fun getExpiration(token : String) : Date {
        return Jwts.parser()
            .setSigningKey(this.resolvePasskey())
            .parseClaimsJws(token)
            .body.expiration
    }
}

private class AuthenticatedUser () {
    constructor(authUserDetails: LoginUserDetails) : this() {
        id = authUserDetails.getUniqueId()
        username = authUserDetails.username
    }
    var username : String? = ""
    var id : String? = ""
}