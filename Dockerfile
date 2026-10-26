# Etapa 1: compila el proyecto dentro de Docker, para que Render siempre use el codigo actual
FROM maven:3.9-amazoncorretto-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -B dependency:go-offline
COPY src ./src
RUN mvn -q -B -DskipTests package

# Etapa 2: imagen liviana solo con el jar
FROM amazoncorretto:21-alpine-jdk
COPY --from=build /app/target/ToDoList-0.0.1-SNAPSHOT.jar /ToDoListBackend.jar
ENTRYPOINT ["java","-jar","/ToDoListBackend.jar"]
