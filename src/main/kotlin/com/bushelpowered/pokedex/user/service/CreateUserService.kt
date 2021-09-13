package com.bushelpowered.pokedex.user.service

import com.bushelpowered.pokedex.resource.User

/**
 * Interface to a service that creates a {@link User}.
 */
interface CreateUserService {

    fun createUser(user: User) : User
}