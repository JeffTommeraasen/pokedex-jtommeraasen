package com.bushelpowered.pokedex.pokemon.search.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pokedex/v1")
class PokemonsController {

    @GetMapping("/pokemons")
    fun listPokemon(startIndex: Int, count: Int): List<String> {
        return listOf("myString")
    }
}