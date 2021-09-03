package com.bushelpowered.pokedex.account.repository.mapper

import com.bushelpowered.pokedex.account.repository.UserDto
import com.bushelpowered.pokedex.resource.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
open interface UserMapper {

    @Insert("insert into user(user_id, password, email, unique_id) values (#{userId}, #{password}, #{email}, #{uniqueId})")
    fun createUser(user: User)

    @Select("select user_id, password, email, unique_id from user where user_id = #{userId} and password = #{password}")
    fun getUser(@Param("userId") userId: String, @Param("password") password: String) : UserDto
}