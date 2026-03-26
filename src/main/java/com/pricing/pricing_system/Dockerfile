# # Stage 1: Build the JAR
# FROM eclipse-temurin:21-jdk-alpine AS build
# WORKDIR /workspace

# # Copy Maven wrapper and pom.xml first
# COPY mvnw* pom.xml ./
# COPY .mvn .mvn

# # Copy source code
# COPY src src

# # Make mvnw executable and build
# RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests

# # Stage 2: Run the JAR
# FROM eclipse-temurin:21-jdk-alpine
# WORKDIR /app
# COPY --from=build /workspace/target/*.jar app.jar
# ENTRYPOINT ["java","-jar","app.jar"]

# Stage 1: Build the JAR
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the JAR
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
CMD ["java", "-jar", "app.jar"]
