package com.bushelpowered.pokedex.pokemon.search.repository.mapper

import com.bushelpowered.pokedex.resource.Pokemon
import org.springframework.stereotype.Component

@Component
class DefaultSearchRepository(searchMapper : SearchMapper) : SearchRepository {

    private val searchMapper: SearchMapper = searchMapper

    override fun searchById(id: Int): List<Pokemon> {
        println("DEBUG::results=" + searchMapper.searchById(id))
        return searchMapper.searchById(id)
    }

    override fun searchByCaptured(captured: Int): List<Pokemon> {
        return searchMapper.searchByCaptured(captured)
    }
}