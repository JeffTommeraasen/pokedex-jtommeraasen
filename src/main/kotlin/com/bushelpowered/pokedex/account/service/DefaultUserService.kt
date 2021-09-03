package com.bushelpowered.pokedex.account.service

import com.bushelpowered.pokedex.account.repository.DefaultUserRepository
import com.bushelpowered.pokedex.exceptions.ExistsException
import com.bushelpowered.pokedex.resource.User
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

/**
 * Default implementation of {@link UserService}.
 */
@Component
class DefaultUserService(accountRepository : DefaultUserRepository) : UserService {

    val accountRepository : DefaultUserRepository = accountRepository

    override fun createUser(user: User): User {
        println("DefaultUserService.createUser() invoked")
        val fetchedUser = accountRepository.getUser(user)
        if (fetchedUser != null) {
            throw ExistsException(HttpStatus.CONFLICT, "The specified user already exists.")
        }
        println("fetchedUser null=" + (fetchedUser == null) + " value=" + fetchedUser)
        accountRepository.create(user)
        println("new user created, user=[" + user + "")
        return user
    }
}