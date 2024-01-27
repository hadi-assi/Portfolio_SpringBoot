



FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Pass the database details as arguments
ARG DB_HOST=localhost
ARG DB_PORT=5432


ENV DB_NAME=default_name
ENV DB_USER=default_user
ENV DB_PASS=default_password

ENV MAIL_USERNAME=default_user
ENV MAIL_PASSWORD=default_pass


RUN ./mvnw clean package "-Dspring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}" \
    "-Dspring.datasource.username=${DB_USER}" \
    "-Dspring.datasource.password=${DB_PASS}"

COPY src src
COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]
