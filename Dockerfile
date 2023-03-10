# FROM eclipse-temurin:19-jdk-alpine
FROM openjdk:19-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar", "-s", "text", "-e", "search"]