
# Start with a base image containing Java runtime
FROM openjdk:11-jre-slim

# Add Maintainer Info
LABEL maintainer="http://www.pranadevs.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
#EXPOSE 8080

# The application's jar file
ARG JAR_FILE=latifi.jar

# Add the application's jar to the container
ADD ${JAR_FILE} latifi.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/latifi.jar"]