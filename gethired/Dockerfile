# Use the official OpenJDK image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/gethired-0.0.1-SNAPSHOT.jar gethired-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "gethired.jar"]
