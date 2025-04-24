FROM openjdk:25-ea-4-jdk-oraclelinux9

# Add a volume for logs (optional)
VOLUME /tmp

WORKDIR /app

# Copy and run the JAR file
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
