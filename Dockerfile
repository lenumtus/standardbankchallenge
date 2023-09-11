#FROM maven:3.6.3-jdk-11-slim AS MAVEN_BUILD
#MAINTAINER lenumtus
#COPY pom.xml /build/
#COPY src /build/src/
#WORKDIR /build/
#RUN mvn clean install && mvn package -B -e
#FROM openjdk:11-slim
#WORKDIR /app
#COPY --from=MAVEN_BUILD /build/target/standardbankchallenge-0.0.1.jar /app/standardbankchallenge.jar
#ENTRYPOINT ["java", "-jar", "standardbankchallenge.jar"]
FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8999
# Refer to Maven build -> finalName
ARG JAR_FILE=target/standardbankchallenge-0.0.1.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
