package com.bushelpowered.pokedex.pokemon.search.service

import com.bushelpowered.pokedex.resource.Pokemon

interface SearchService {

    open fun searchById(id: Int): List<Pokemon>

    open fun searchByCaptured(captured: Boolean) : List<Pokemon>
}