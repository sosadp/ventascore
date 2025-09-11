# Imagen base de Java
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo
WORKDIR /app

# Copiamos el jar generado por Maven/Gradle
COPY target/ventas-app.jar app.jar

# Exponemos el puerto
EXPOSE 8082

# Ejecutamos la app con el perfil que se pasa en el docker-compose
ENTRYPOINT ["java", "-jar", "app.jar"]