package com.bushelpowered.pokedex.user.repository

import com.bushelpowered.pokedex.resource.User

interface UserRepository {

    fun getUserDetails(username: String?) : UserDto

    fun create(user: User)

    fun exists(user: User) : Boolean
}