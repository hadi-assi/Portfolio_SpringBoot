#
# Build stage
#
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM adoptopenjdk/openjdk21:alpine-jre
COPY --from=build /target/protfolio-0.0.1-SNAPSHOT.jar protfolio.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","protfolio.jar"]
