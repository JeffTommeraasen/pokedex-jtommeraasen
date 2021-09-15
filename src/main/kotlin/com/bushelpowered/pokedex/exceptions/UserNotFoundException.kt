package com.bushelpowered.pokedex.exceptions

import org.springframework.dao.DataAccessException

class UserNotFoundException(val msg: String) : DataAccessException(msg) {

}