package com.bushelpowered.pokedex.pokemon.search.service

import com.bushelpowered.pokedex.pokemon.search.repository.mapper.DefaultSearchRepository
import com.bushelpowered.pokedex.pokemon.search.repository.mapper.SearchRepository
import com.bushelpowered.pokedex.resource.Pokemon
import org.springframework.stereotype.Component

@Component
class DefaultSearchService(searchRepository: DefaultSearchRepository) : SearchService {

    private val searchRepository : DefaultSearchRepository = searchRepository

    override fun searchById(id: Int): List<Pokemon> {
        println("DEBUG::defaultSearchService.searchById:()::invoked")
        println("DEBUG::search id=" + id)
        return searchRepository.searchById(id)
    }

    override fun searchByCaptured(captured: Boolean): List<Pokemon> {
            TODO("Not yet implemented")
    }
}