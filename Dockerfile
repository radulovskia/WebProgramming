FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn test
RUN mvn clean install -DskipTests

FROM openjdk:17
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/target/lab-0.0.1-SNAPSHOT.jar ./lab.jar
ENTRYPOINT ["java", "-jar", "lab.jar"]