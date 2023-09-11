FROM maven:3.6.3-jdk-11-slim AS MAVEN_BUILD
MAINTAINER lenumtus
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn clean install && mvn package -B -e
FROM openjdk:11-slim
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/standardbankchallenge.jar /app/standardbankchallenge.jar
ENTRYPOINT ["java", "-jar", "standardbankchallenge.jar"]
