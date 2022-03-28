FROM adoptopenjdk/openjdk11:ubi

EXPOSE 8080

ADD target/AuthorizationService-0.0.1-SNAPSHOT.jar myapp.jar

ENTRYPOINT ["java", "-jar", "/myapp.jar"]