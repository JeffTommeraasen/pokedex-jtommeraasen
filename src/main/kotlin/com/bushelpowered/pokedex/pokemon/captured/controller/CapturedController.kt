package com.bushelpowered.pokedex.pokemon.captured.controller

import com.bushelpowered.pokedex.pokemon.captured.service.CapturedService
import com.bushelpowered.pokedex.pokemon.captured.service.DefaultCapturedService
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@PreAuthorize("hasRole('TRAINER')")
@RequestMapping("/v1")
open class CapturedController(capturedService: DefaultCapturedService) {

    private val capturedService: CapturedService = capturedService

    @PostMapping(value=arrayOf("/captured/{id}"))
    open fun capture(@PathVariable("id") id: Int) {
        capturedService.capture(id)
    }

    @PostMapping(value=arrayOf("/uncaptured/{id}"))
    open fun uncapture(@PathVariable("id") id: Int) {
        capturedService.uncapture(id)
    }
}