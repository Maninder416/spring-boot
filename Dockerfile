FROM openjdk:17-jdk
ADD target/*.jar app.jar
EXPOSE 8080
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]