FROM openjdk:8
ADD target/clientes-service.jar clientes-service.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "clientes-service.jar"]