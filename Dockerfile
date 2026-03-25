# Use official JDK 21 image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy built jar from target folder
COPY target/*.jar app.jar

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
