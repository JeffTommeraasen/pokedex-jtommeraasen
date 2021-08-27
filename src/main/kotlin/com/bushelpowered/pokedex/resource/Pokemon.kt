package com.bushelpowered.pokedex.resource

/**
 * Data resource to encapsulate the attributes of a Pokemon.
 */
data class Pokemon(
    val id: Int,
    val name: String,
    val types: Types,
    val height: Double,
    val weight: Double,
    val abilities: Abilities,
    val eggGroups: EggGroups,
    val stats: Stats,
    val genus: String,
    val description: String) {

}
