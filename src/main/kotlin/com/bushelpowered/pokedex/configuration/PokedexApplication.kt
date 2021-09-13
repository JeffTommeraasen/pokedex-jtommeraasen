package com.bushelpowered.pokedex.configuration

import com.bushelpowered.pokedex.configuration.security.SecurityConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import

@SpringBootApplication
@ComponentScan(value=["com.bushelpowered.pokedex"])
@Import(DataAccessConfig::class, SecurityConfig::class)
open class PokedexApplication

fun main(args: Array<String>) {
    runApplication<PokedexApplication>(*args)
}