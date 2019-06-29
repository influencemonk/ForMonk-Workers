# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="majumdartanmay68@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp
# Make port 5000 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/MonkOAuth-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
COPY ./build/libs/MonkOAuth-0.0.1-SNAPSHOT.jar ${JAR_FILE}
WORKDIR target

# Run the jar file 
CMD ["java","-jar","MonkOAuth-0.0.1-SNAPSHOT.jar"]