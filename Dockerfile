# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the jar file into the container
COPY target/tiny-url-service-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8082 as your app listens on this port
EXPOSE 8082

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]