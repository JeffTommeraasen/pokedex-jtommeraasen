package com.bushelpowered.pokedex.mybatis.mapper

import com.bushelpowered.pokedex.user.repository.UserDto
import com.bushelpowered.pokedex.resource.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
open interface UserMapper {

    @Insert("insert into user(user_id, password, email, unique_id, role) values (#{userId}, #{password}, #{email}, #{uniqueId}, #{role})")
    fun createUser(user: User)

    //@Select("select user_id, password, email, unique_id, role from user where user_id = #{userId} and password = #{password}")
    @Select("select exists(select 1 from user where user_id = #{userId})")
    fun exists(@Param("userId") userId: String) : Boolean

    @Select("select user_id, password, email, unique_id, role from user where user_id = #{userId}")
    fun getUserDetails(@Param("userId") userId: String?) : UserDto
}