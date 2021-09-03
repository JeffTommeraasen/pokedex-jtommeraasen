package com.bushelpowered.pokedex.pokemon.search.repository.mapper

import com.bushelpowered.pokedex.resource.Pokemon
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
open interface SearchMapper {

    @Select("select * from pokedex where id = #{id}")
    fun searchById(@Param("id") id: Int) : List<Pokemon>

    @Select("select * from pokedex")
    fun searchByCaptured(@Param("captured") captured: Int) : List<Pokemon>

}