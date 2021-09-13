package com.bushelpowered.pokedex.pokemon.captured.service

interface CapturedService {

    open fun capture(id: Int)

    open fun uncapture(id: Int)
}