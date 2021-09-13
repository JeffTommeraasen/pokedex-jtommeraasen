package com.bushelpowered.pokedex.resource

/**
 * Resource model to encapsulate the details about a given user.
 */
data class User(
    val userId: String,
    var password: String,
    var email: String?,
    var uniqueId: String?,
    val role: String) {
}