FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/*.jar product-service-v-1.0.jar
EXPOSE 9090
ENTRYPOINT ["java", "-Dspring.profiles.active=docker","-jar","product-service-v-1.0.jar"]