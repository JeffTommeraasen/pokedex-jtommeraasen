package com.bushelpowered.pokedex.pokemon.captured.repository

import com.bushelpowered.pokedex.mybatis.mapper.CapturedMapper
import org.springframework.stereotype.Component

@Component
class DefaultCapturedRepository(val capturedMapper: CapturedMapper) : CapturedRepository {

    override fun capture(id: Int) {
        capturedMapper.capture(id, 1)
    }

    override fun uncapture(id: Int) {
        capturedMapper.capture(id, 0)
    }
}