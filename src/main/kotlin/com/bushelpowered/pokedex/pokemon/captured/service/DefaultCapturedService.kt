package com.bushelpowered.pokedex.pokemon.captured.service

import com.bushelpowered.pokedex.pokemon.captured.repository.CapturedRepository
import com.bushelpowered.pokedex.pokemon.captured.repository.DefaultCapturedRepository
import org.springframework.stereotype.Component

@Component
class DefaultCapturedService(capturedRepository: DefaultCapturedRepository) : CapturedService {

    private val capturedRepository : CapturedRepository = capturedRepository

    override fun capture(id: Int) {
        capturedRepository.capture(id)
    }

    override fun uncapture(id: Int) {
        capturedRepository.uncapture(id)
    }
}