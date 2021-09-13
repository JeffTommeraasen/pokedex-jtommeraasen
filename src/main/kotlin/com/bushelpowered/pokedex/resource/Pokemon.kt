package com.bushelpowered.pokedex.resource

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Data resource to encapsulate the attributes of a Pokemon.
 */
data class Pokemon(
    val id: Int,
    val name: String,
    //val types: Types,
//    val types: Array<String>,
    val types: String,
    val height: Double,
    val weight: Double,
    //val abilities: Abilities,
    //val abilities: List<String>,
    val abilities: String,
    //val eggGroups: EggGroups,
    //val eggGroups: List<String>,
    val eggGroups: String,
    //val stats: Stats,
    //val stats: Map<String, String>,
    val stats: String,
    val genus: String,
    val description: String) {

}
