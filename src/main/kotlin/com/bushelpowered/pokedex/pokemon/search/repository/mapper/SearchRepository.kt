package com.bushelpowered.pokedex.pokemon.search.repository.mapper

import com.bushelpowered.pokedex.resource.Pokemon

interface SearchRepository {

    open fun searchById(id: Int) : List<Pokemon>

    open fun searchByCaptured(captured: Int) : List<Pokemon>
}