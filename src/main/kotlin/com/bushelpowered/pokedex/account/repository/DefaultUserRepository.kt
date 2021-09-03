package com.bushelpowered.pokedex.account.repository

import com.bushelpowered.pokedex.account.repository.mapper.UserMapper
import com.bushelpowered.pokedex.resource.User
import org.springframework.stereotype.Component

/**
 * Default implementation of {@link AccountRepository}.
 */
@Component
class DefaultUserRepository(userMapper : UserMapper): UserRepository {

    val userMapper : UserMapper = userMapper

    override fun create(user: User) {
        userMapper.createUser(user)
    }

    override fun getUser(user: User) : UserDto {
        return userMapper.getUser(user.userId, user.password)
    }
}