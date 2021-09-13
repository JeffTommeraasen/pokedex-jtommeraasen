package com.bushelpowered.pokedex.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

/**
 * A subclass of {@link ResponseStatusException} to indicate a resource already exists.<br/><br/>
 *
 * This exception wraps a 409 CONFLICT http status code.
 */
class ExistsException(status: HttpStatus = HttpStatus.CONFLICT, message: String = "The resource already exists.") : ResponseStatusException(status, message) {

}