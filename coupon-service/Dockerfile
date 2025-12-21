FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/coupon-service-0.0.1-SNAPSHOT.jar coupon-service.jar

EXPOSE 9091

ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "coupon-service.jar"]
