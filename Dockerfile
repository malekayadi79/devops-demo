# ---- build stage: compile, test and package with Maven ----
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /src
COPY pom.xml .
RUN mvn -B -q dependency:go-offline
COPY src ./src
RUN mvn -B package

# ---- runtime stage: JRE only, non-root ----
FROM eclipse-temurin:21-jre-jammy
RUN useradd --uid 10001 --no-create-home app
WORKDIR /app
COPY --from=build /src/target/devops-demo-1.0-SNAPSHOT.jar app.jar
USER 10001
ENTRYPOINT ["java", "-jar", "app.jar"]
