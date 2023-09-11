FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8999
ARG JAR_FILE=target/standardbankchallenge-0.0.1.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]
