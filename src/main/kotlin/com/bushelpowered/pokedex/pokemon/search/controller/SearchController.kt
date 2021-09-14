package com.bushelpowered.pokedex.pokemon.search.controller

import com.bushelpowered.pokedex.pokemon.search.service.SearchService
import com.bushelpowered.pokedex.resource.Pokemon
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@PreAuthorize("hasRole('TRAINER')")
@RequestMapping("/v1")
open class SearchController(val searchService: SearchService) {

    @GetMapping("/pokemon/{id}")
    open fun getPokemon(@PathVariable("id") id: Int): ResponseEntity<List<Pokemon>> {
        val pokemon : List<Pokemon> = searchService.searchById(id)
        return ResponseEntity(pokemon, HttpStatus.OK)
    }

    @GetMapping("/pokemon/captured")
    open fun getPokemonByCapturedStatus(@RequestParam("captured") captured: Boolean): ResponseEntity<List<Pokemon>> {
        val pokemon : List<Pokemon> = searchService.searchByCaptured(captured)
        return ResponseEntity(pokemon, HttpStatus.OK)
    }

    @GetMapping("/pokemons")
    open fun listPokemon(@RequestParam("id") id: Int, @RequestParam("count") count: Int) : ResponseEntity<List<Pokemon>> {
        val pokemons : List<Pokemon> = searchService.searchByIdAndCount(id, count)
        return ResponseEntity(pokemons, HttpStatus.OK)
    }
}