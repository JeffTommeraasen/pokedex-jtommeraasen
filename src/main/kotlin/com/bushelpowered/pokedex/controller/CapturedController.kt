package com.bushelpowered.pokedex.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pokedex/v1")
class CapturedController {
    // TODO - JT - update parameter to a path param.
    @PostMapping(value=arrayOf("/captured"))
    fun updateCaptured(id: String) {
        
    }
}