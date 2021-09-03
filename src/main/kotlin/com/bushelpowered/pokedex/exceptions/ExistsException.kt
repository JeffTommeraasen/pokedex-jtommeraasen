package com.bushelpowered.pokedex.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class ExistsException(status: HttpStatus = HttpStatus.CONFLICT, message: String = "The resource already exists.") : ResponseStatusException(status, message) {

}