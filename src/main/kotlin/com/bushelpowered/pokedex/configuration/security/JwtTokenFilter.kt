package com.bushelpowered.pokedex.configuration.security

import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtTokenFilter(
    val userDetailsService : UserDetailsService,
    val jwtTokenUtil: JwtTokenUtil) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain) {
        val header: String? = request.getHeader(HttpHeaders.AUTHORIZATION)
        if (header != null) {
            if (header?.isEmpty() || !header.startsWith("Bearer ")) {
                filterChain.doFilter(request, response)
                return
            }

            val token: String = header.split(" ")[1].trim()
            if (!jwtTokenUtil.validate(token)) {
                filterChain.doFilter(request, response)
                return
            }

            val userDetails: UserDetails = userDetailsService.loadUserByUsername(jwtTokenUtil.getUsername(token))
            val authentication: UsernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.authorities)
            authentication.setDetails(WebAuthenticationDetailsSource().buildDetails(request))
            SecurityContextHolder.getContext().setAuthentication(authentication)
        }
        filterChain.doFilter(request, response)
    }
}