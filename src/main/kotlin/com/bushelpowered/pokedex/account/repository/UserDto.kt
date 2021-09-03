package com.bushelpowered.pokedex.account.repository

import com.bushelpowered.pokedex.resource.User

class UserDto(
    val userId: String,
    val password: String,
    val email: String,
    val uniqueId: String) {

    fun toUser() : User {
        return User(userId, password, email, uniqueId)
    }
}