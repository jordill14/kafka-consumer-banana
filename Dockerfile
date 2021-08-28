FROM adoptopenjdk:11.0.11_9-jre-hotspot

COPY build/libs/*.jar banana.jar

EXPOSE 8282

CMD ["java", "-jar", "/banana.jar"]