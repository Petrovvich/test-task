FROM maven:3.6.0-jdk-11-slim as build
RUN mkdir app/
COPY . .
RUN mvn package && cp ./target/cinema-app.jar /app/app.jar
WORKDIR /app

FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
COPY --from=build target/cinema-app.jar cinema-app.jar
EXPOSE 8080
CMD java -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar cinema-app.jar