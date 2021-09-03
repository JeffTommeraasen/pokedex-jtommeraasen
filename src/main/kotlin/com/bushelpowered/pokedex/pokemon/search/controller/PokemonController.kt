package com.bushelpowered.pokedex.pokemon.search.controller

import com.bushelpowered.pokedex.account.service.UserService
import com.bushelpowered.pokedex.pokemon.search.service.DefaultSearchService
import com.bushelpowered.pokedex.pokemon.search.service.SearchService
import com.bushelpowered.pokedex.resource.Pokemon
import com.bushelpowered.pokedex.resource.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/pokedex/v1")
class PokemonController(searchService: DefaultSearchService, userService: UserService) {

    private val searchService: SearchService = searchService
    private val userService: UserService = userService
    @GetMapping("/pokemon/{id}")
    fun getPokemon(@PathVariable("id") id: Int): ResponseEntity<*> { //List<Pokemon> {
//    fun createAccount(@RequestBody user: User): ResponseEntity<*> {
        println("DEBUG::Entered search controller.")
        return ResponseEntity(searchService.searchById(id), HttpStatus.OK)
        //return userService.createUser(user);
    }
}