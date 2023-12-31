FROM maven:3.6.3-jdk-8 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM maven:3.6.3-jdk-8
COPY --from=build /home/app/target/devops-practice-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
ENTRYPOINT ["java", "-jar", "/usr/local/lib/demo.jar"]
