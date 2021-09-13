package com.bushelpowered.pokedex.pokemon.captured.repository

interface CapturedRepository {

    fun capture(id: Int)

    fun uncapture(id: Int)
}