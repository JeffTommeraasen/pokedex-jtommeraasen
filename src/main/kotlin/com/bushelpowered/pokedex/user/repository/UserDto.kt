package com.bushelpowered.pokedex.user.repository

import com.bushelpowered.pokedex.resource.User

class UserDto(
    val userId: String,
    val password: String,
    val email: String,
    val uniqueId: String,
    val role: String) {

    fun toUser() : User {
        return User(userId, password, email, uniqueId, role)
    }
}