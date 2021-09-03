package com.bushelpowered.pokedex.account.repository

import com.bushelpowered.pokedex.resource.User

interface UserRepository {

    fun create(user: User)

    fun getUser(user: User) : UserDto
}