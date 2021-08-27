package com.bushelpowered.pokedex.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(value=["com.bushelpowered.pokedex"])
open class PokedexJtommeraasenApplication

fun main(args: Array<String>) {
    runApplication<PokedexJtommeraasenApplication>(*args)
}