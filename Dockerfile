FROM openjdk:17-oracle
COPY ./target/security-0.0.1-SNAPSHOT.jar security.jar
CMD ["java","-jar","security.jar"]