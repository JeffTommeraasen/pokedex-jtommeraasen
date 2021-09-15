package com.bushelpowered.pokedex.configuration.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    securedEnabled = true,
    jsr250Enabled = true,
    prePostEnabled = true
)
open class PokedexSecurityConfigurerAdapter(
    val userDetailsService : UserDetailsService,
    val jwtFilter : JwtTokenFilter) : WebSecurityConfigurerAdapter() {

    init {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL)
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        if (auth != null) {
            auth.userDetailsService(userDetailsService)
            auth.eraseCredentials(false)
        }
    }

    override fun configure(http: HttpSecurity) {
        http.cors()
            .and().csrf().disable()
            .exceptionHandling()
            .authenticationEntryPoint(AuthEntryPoint())
            .and().headers().frameOptions().disable() // h2 console
            .and().authorizeRequests()
            .antMatchers("/v1/login").permitAll() // user login
            .antMatchers("/v1/user").permitAll() // user create
            .antMatchers("/").permitAll() // h2 console
            .antMatchers("/h2-console/**").permitAll() // h2 console
            .anyRequest().authenticated()
            .and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
    }

    class AuthEntryPoint : AuthenticationEntryPoint {
        override fun commence(req: HttpServletRequest, res: HttpServletResponse, exception: AuthenticationException) {
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.message)
        }
    }

    @Throws(java.lang.Exception::class)
    override fun configure(webSecurity: WebSecurity) {
        webSecurity.ignoring().antMatchers(
            "/v2/api-docs",
            "/configuration/ui",
            "/swagger-resources",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/swagger-resources/**",
            "/swagger-ui/**"
        )
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager? {
        return super.authenticationManagerBean()
    }
}