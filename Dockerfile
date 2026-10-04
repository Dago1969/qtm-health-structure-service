FROM eclipse-temurin:17-jre
WORKDIR /opt/app
COPY target/qtm-health-structure-service-1.0.0.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]