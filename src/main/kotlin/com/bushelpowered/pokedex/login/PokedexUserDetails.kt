package com.bushelpowered.pokedex.login

import com.bushelpowered.pokedex.user.repository.UserDto
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

class PokedexUserDetails(private val userDto: UserDto) : LoginUserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val authorities: MutableList<GrantedAuthority> = ArrayList()
        authorities.add(SimpleGrantedAuthority("ROLE_" + userDto.role))
        return authorities
    }

    override fun getPassword(): String? {
        return userDto.password
    }

    override fun getUsername(): String? {
        return userDto.userId
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    override fun getUniqueId(): String {
        return userDto.uniqueId
    }

    override fun getEmail(): String {
        return userDto.email
    }
}