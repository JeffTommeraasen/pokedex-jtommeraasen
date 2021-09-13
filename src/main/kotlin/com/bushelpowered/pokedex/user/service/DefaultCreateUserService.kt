package com.bushelpowered.pokedex.user.service

import com.bushelpowered.pokedex.exceptions.ExistsException
import com.bushelpowered.pokedex.resource.User
import com.bushelpowered.pokedex.user.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

/**
 * Default implementation of {@link UserService}.
 */
@Component
class DefaultCreateUserService(val userRepository : UserRepository, val passwordEncoder: PasswordEncoder) : CreateUserService {

    override fun createUser(user: User): User {
        user.password = passwordEncoder.encode(user.password)
        if (userRepository.exists(user)) {
            throw ExistsException(HttpStatus.CONFLICT, "The specified user already exists.")
        }
        userRepository.create(user)
        return user
    }
}