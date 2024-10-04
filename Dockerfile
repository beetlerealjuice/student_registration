FROM openjdk:17-oracle

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 8082

CMD ["java", "-jar", "app.jar"]
