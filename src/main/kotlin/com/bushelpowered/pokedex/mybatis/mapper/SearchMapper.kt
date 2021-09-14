package com.bushelpowered.pokedex.mybatis.mapper

import com.bushelpowered.pokedex.resource.Pokemon
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
open interface SearchMapper {

    @Select("select * from pokedex where ids = #{id}")
//    @Results(id = "pokemons", value=[
//        Result(column="types", property="types", javaType=Types::class, typeHandler=StringTypeHandler::class)
//    ])
    fun searchById(@Param("id") id: Int) : List<Pokemon>

    @Select("select * from pokedex p, captured_pokemon c where p.id = c.id and c.captured = 1")
    fun searchByCaptured(@Param("captured") captured: Int) : List<Pokemon>

    @Select("select * from pokedex p, captured_pokemon c where p.id not in (select c.id from captured_pokemon c) or (p.id = c.id and (c.captured = null or c.captured = 0))")
    fun searchByUncaptured() : List<Pokemon>

    @Select("select * from pokedex where id >= #{id} and id <= (#{id} + #{count})")
    fun searchByPagination(id: Int, count: Int) : List<Pokemon>
}