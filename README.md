# Message API
## Description
A simple message API built in Java with Spring Boot <br>

## Requirements
1. Create an endpoint that receives a JSON request with fields "id" and "message"
2. Return a response with the total word count of all messages received.
3. Ignore duplicate message IDs <br>

## Build Pre Req
Install Java 8 and add to your path: <br>
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html <br>
<br>Confirm with Powershell or Bash Terminal: <br>
$ java -version <br>
java version "1.8.0_xxx" <br>

## Build and Run
### Run Local
From ./Message-API run the following command: <br>
$ ./mvnw spring-boot:run
### Build Jar
From ./Message-API run the following command: <br>
$ ./mvnw clean <br>
Message-API-0.0.1-SNAPSHOT.jar should be created in ./target
### Run Jar
From .Message-API/target run the following command: <br>
$ java -jar Message-API-0.0.1-SNAPSHOT.jar <br>
The service should be running on localhost:8080
### Send Request
From postman send a POST request to http://localhost:8080/message <br>
with a body of {"id":"123","message":"I want to walk my ..  dog 1 "} <br>
The response should be: <br>
Status: 200 OK <br>
Body: <br>
{<br>
    "count":6 <br>
}






