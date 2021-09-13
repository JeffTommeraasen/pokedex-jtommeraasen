package com.bushelpowered.pokedex.user.service

import com.bushelpowered.pokedex.login.PokedexUserDetails
import com.bushelpowered.pokedex.user.repository.UserDto
import com.bushelpowered.pokedex.user.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class DefaultUserDetailsService(val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val userDto : UserDto = userRepository.getUserDetails(username)
        return PokedexUserDetails(userDto);
    }
}