package com.bushelpowered.pokedex.resource

import com.fasterxml.jackson.annotation.JsonCreator

enum class Sort(var value: String) {
    ASCENDING("ASCENDING"),
    DESCENDING("DESCENDING");

    override fun toString() : String {
        return value;
    }

    @JsonCreator
    fun from(value: String) {
        this.value = value
    }

}