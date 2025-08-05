# Build stage
FROM maven:3.8.1-openjdk-8-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY --from=build /app/target/bloodpressure-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080