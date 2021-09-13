package com.bushelpowered.pokedex.resource

import org.springframework.http.HttpStatus

data class ResponseError(
    val status: HttpStatus,
    val code: Int,
    val error: String? = "An error occurred while processing the request.") {
}