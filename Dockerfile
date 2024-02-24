FROM openjdk:11-jre

RUN mkdir app

COPY /target/crud_usuarios-0.0.1-SNAPSHOT.jar /app/crud_usuarios.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "crud_usuarios.jar"]