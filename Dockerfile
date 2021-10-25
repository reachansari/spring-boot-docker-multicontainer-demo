FROM openjdk:8-jdk-alpine
LABEL maintainer="reachansari" 
VOLUME /tmp
EXPOSE 8080
ADD target/spring-boot-docker-multicontainer-demo-0.0.1-SNAPSHOT.jar springbootpostgresqldocker.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springbootpostgresqldocker.jar"]