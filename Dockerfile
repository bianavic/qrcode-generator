# syntax=docker/dockerfile:1

FROM gradle:gradle-8.5 AS builder

LABEL maintainer ="fabferlin"

WORKDIR /app

COPY . .
RUN ./gradlew build
FROM openjdk:17

COPY build/libs/qrcode-generator-0.0.1-SNAPSHOT.jar .

EXPOSE 9191

CMD ["java", "-jar", "qrcode-generator-0.0.1-SNAPSHOT.jar"]