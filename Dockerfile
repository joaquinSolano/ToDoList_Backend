FROM amazoncorretto:21-alpine-jdk
MAINTAINER ESMERALDA
COPY target/ToDoList-0.0.1-SNAPSHOT.jar ToDoListBackend.jar
ENTRYPOINT ["java","-jar","/ToDoListBackend.jar"]