package com.bushelpowered.pokedex.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.*
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
open class SwaggerConfig {

    @Bean
    open fun swaggerApi(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInformation())
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
            .securityContexts(listOf(securityInfo()))
            .securitySchemes(listOf(ApiKey("JWT", "Authorization", "header")))
    }

    private fun apiInformation(): ApiInfo {
        return ApiInfoBuilder()
            .title("Pokedex REST API")
            .description("My description")
            .contact(Contact("jeff tommeraasen", "", "jtommeraasen@bushelpowered.com"))
            .license("gpl/gnu/free/etc/blah")
            .version(".01")
            .build()
    }

    fun securityInfo(): SecurityContext {
        val scope = AuthorizationScope("global", "accessEverything")
        val scopes = listOf(SecurityReference("JWT", arrayOf(scope)))
        return SecurityContext.builder()
            .securityReferences(scopes)
            .build()
    }
}