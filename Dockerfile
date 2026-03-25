# Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy built jar from target folder
COPY target/*.jar app.jar

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
