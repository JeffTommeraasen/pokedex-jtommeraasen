package com.bushelpowered.pokedex.pokemon.search.repository

import com.bushelpowered.pokedex.resource.Pokemon

interface SearchRepository {

    open fun searchById(id: Int): List<Pokemon>

    open fun searchByCaptured(captured: Boolean): List<Pokemon>

    open fun searchByIdAndCount(id: Int, count: Int): List<Pokemon>
}