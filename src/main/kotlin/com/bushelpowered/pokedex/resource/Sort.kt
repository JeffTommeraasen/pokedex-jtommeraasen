package com.bushelpowered.pokedex.resource

import com.fasterxml.jackson.annotation.JsonCreator

enum class Sort(var description: String, var value: String) {
    ASCENDING("ASCENDING", ""),
    DESCENDING("DESCENDING", "DESC");

    override fun toString() : String {
        return value;
    }

    @JsonCreator
    fun from(description: String) {
        this.description = description
    }

}