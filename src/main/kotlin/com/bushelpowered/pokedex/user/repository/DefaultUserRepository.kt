package com.bushelpowered.pokedex.user.repository

import com.bushelpowered.pokedex.resource.User
import com.bushelpowered.pokedex.mybatis.mapper.UserMapper
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class DefaultUserRepository(val userMapper: UserMapper) : UserRepository {

    override fun getUserDetails(username: String?): UserDto {
        return userMapper.getUserDetails(username)
    }

    override fun create(user: User) {
        userMapper.createUser(user)
    }

    override fun exists(user: User) : Boolean {
        return userMapper.exists(user.userId)
    }
}