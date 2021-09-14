package com.bushelpowered.pokedex.pokemon.search.service

import com.bushelpowered.pokedex.pokemon.search.repository.DefaultSearchRepository
import com.bushelpowered.pokedex.resource.Page
import com.bushelpowered.pokedex.resource.Pokemon
import org.springframework.stereotype.Component

@Component
class DefaultSearchService(val searchRepository: DefaultSearchRepository) : SearchService {

    override fun searchById(id: Int): List<Pokemon> {
        return searchRepository.searchById(id)
    }

    override fun searchByCaptured(captured: Boolean): List<Pokemon> {
        return searchRepository.searchByCaptured(captured)
    }

    override fun searchByPage(page: Page) : List<Pokemon> {
        return searchRepository.searchByPage(page)
    }

}