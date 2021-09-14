package com.bushelpowered.pokedex.resource

class Page(
    val id: Int?,
    val count: Int?,
    var sort: Sort? = Sort.ASCENDING) {
}