FROM openjdk:17-jdk
ADD target/employee-crud-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9003
ENTRYPOINT ["java","-jar","app.jar"]