FROM gradle:7.2.0-jdk11-openj9 AS build
ENV APP_HOME=/app
WORKDIR $APP_HOME

#Build logic
COPY build.gradle $APP_HOME/build.gradle
COPY settings.gradle $APP_HOME/settings.gradle
COPY src ./src

RUN gradle clean build

#Container logic
FROM openjdk:11.0.12-jre-slim

WORKDIR app

COPY --from=build /app/build/libs/pokedex-jtommeraasen-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

cmd [ "java", "-jar", "pokedex-jtommeraasen-0.0.1-SNAPSHOT.jar" ]
