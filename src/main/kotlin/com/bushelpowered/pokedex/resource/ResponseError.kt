package com.bushelpowered.pokedex.resource

import org.springframework.http.HttpStatus

data class ResponseError(
    val status: HttpStatus,
    val message: String? = "An error occurred while processing the request."
) {
}