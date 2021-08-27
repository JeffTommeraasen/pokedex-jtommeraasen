package com.bushelpowered.pokedex.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pokedex/v1")
class PokemonController {

    // TODO - JT - update to set id as a path param.
    @GetMapping("/pokemon")
    fun getPokemon(id: Int): List<String> {
        return listOf("myString")
    }
}