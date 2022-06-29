#Start with a base image containing Java runtime
FROM openjdk:11-slim

#Informatiopn around who maintains the image
MAINTAINER andres.com

#Add the application's jar tot the container
COPY target/oneToMany-0.0.1-SNAPSHOT.jar oneToMany-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java", "-jar", "oneToMany-0.0.1-SNAPSHOT.jar"]