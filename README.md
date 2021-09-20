# Pokedex REST Application 
This application allows a user to create a user account, login, and perform varying operations on a pokemon.

# Building the Application

This application uses Gradle. To build, please run:

`gradle clean build` 

# Running the Application

This Spring Boot application can be ran by executing the jar file.

From the application workspace directory, run:

`java -jar ./build/libs/pokedex-0.0.1-SNAPSHOT.jar`

#REST Endpoints

1. > `pokedex/v1/user`
    - PUT - creates a new user account.
    - Requires a new <b>User</b> `@RequestBody` with attributes: <i>userId, password, email,</i> and <i>role</i>.
   
2. >`pokedex/v1/login`
    - POST - execute a user login.
    - Requires a user login `@RequestBody` with the atttributes: <i>username</i> and <i>password</i>.
   
3. > `pokedex/v1/pokemon/{id}`
    - GET - fetches a specific pokemon.
    - Requires an id (Integer) path parameter.

4. > `pokedex/v1/pokemons`
    - GET - fetch a (pageable) list of pokemons in pokedex
    - Requires <i>id,</i> and <i>count</> request parameters.
    - Optional <i>sort</i> parameter.
   
5. > `pokedex/v1/captured`
    - GET - list the captured pokemons in pokedex.
   
6. > `pokedex/v1/captured/{id}`
    - POST - capture a pokemon using it's id.

7. > `pokedex/v1/uncaptured/{id}`
    - POST - uncapture a pokemon using it's id.

# Miscellanous

## H2 Console
 > http://localhost:8080/pokedex/h2-console

## Swagger
 > http://localhost:8080/pokedex/swagger-ui.html
