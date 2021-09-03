package com.bushelpowered.pokedex.account.service

import com.bushelpowered.pokedex.resource.User

/**
 *
 */
interface UserService {

    fun createUser(user: User) : User
}