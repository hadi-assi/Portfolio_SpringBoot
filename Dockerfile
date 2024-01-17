#
# Build stage
#
FROM maven:3.8.5-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:21-jdk-slim
COPY --from=build /target/protfolio-0.0.1-SNAPSHOT.jar protfolio.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","protfolio.jar"]
