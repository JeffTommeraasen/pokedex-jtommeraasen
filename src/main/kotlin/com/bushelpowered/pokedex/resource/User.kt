package com.bushelpowered.pokedex.resource

/**
 * Resource model to encapsulate the details about a given user.
 */
data class User(
    val userId: String,
    val password: String,
    val email: String,
    var uniqueId: String?) {
}