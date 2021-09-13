package com.bushelpowered.pokedex.resource

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data resource to encapsulate a Pokemon's types.
 */
data class Types(
    @JsonProperty(value="types")
    val types: Array<String>) {
    //val types: List<String>) {
    //val types: String) {
}