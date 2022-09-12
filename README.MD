# **ISTAT Italian Municipalities**

This is a service that uses ISTAT data. 
It exposes via REST API different data extracted from the 
official csv publicly available on the official ISTAT website.
The project was developed using Spring Boot and uses H2 as in-memory database.
Dataset is available at https://www.istat.it/storage/codici-unita-amministrative/Elenco-comuni-italiani.csv

# Building

## Requirements
Building the Italian Municipalities requires the following tools:

* JDK 11 (Oracle's JDK or OpenJDK recommended)
* Apache Maven 3.1.1+ (3.2+ recommended but i used Maven 3.8.2) 
* Git (obviously)

## Run project locally
```
git clone ...
cd Italian_municipalities
mvn clean package -DskipTests=true
java -jar .\target\Italian_municipalities-0.0.1.jar
```
The service is available at http://localhost:8080.
Swagger ui is available at http://localhost:8080/swagger-ui/index.html

if you want to change the port or other configurations of h2 you can use the variables referenced in the application.properties file.
```
java -Dserver_port=7070 -jar .\target\Italian_municipalities-0.0.1.jar
```
If you use an ide like intellij these commands are available in the ide ui.
