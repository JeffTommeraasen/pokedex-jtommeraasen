package com.bushelpowered.pokedex.login

import org.springframework.security.core.userdetails.UserDetails

interface LoginUserDetails : UserDetails {

    fun getUniqueId(): String

    fun getEmail(): String
}