package com.bushelpowered.pokedex.mybatis.mapper

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Update

@Mapper
interface CapturedMapper {

    @Update("merge into captured_pokemon key(id) values(#{id}, #{captured})")
    fun capture(id: Int, captured: Int)
}