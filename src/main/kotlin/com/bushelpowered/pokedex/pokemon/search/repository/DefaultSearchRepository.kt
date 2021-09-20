package com.bushelpowered.pokedex.pokemon.search.repository

import com.bushelpowered.pokedex.mybatis.mapper.SearchMapper
import com.bushelpowered.pokedex.resource.Page
import com.bushelpowered.pokedex.resource.Pokemon
import org.springframework.stereotype.Component

@Component
class DefaultSearchRepository(val searchMapper: SearchMapper) : SearchRepository {

    override fun searchById(id: Int): List<Pokemon> {
        return searchMapper.searchById(id)
    }

    override fun searchByCaptured(captured: Boolean): List<Pokemon> {
        return if(captured) searchMapper.searchByCaptured(1) else searchMapper.searchByUncaptured()
    }

    override fun searchByPage(page: Page) : List<Pokemon> {
        return searchMapper.searchByPagination(page.id, page.count, page.sort?.value)
    }
}