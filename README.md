# Spring WebFlux Demo

This project is a demo showcasing the implementation of Reactive Programming with Spring Boot, R2DBC, and H2 Database. The goal of this project is to demonstrate how to build a reactive application using Spring Boot's powerful features and leverage the benefits of R2DBC for interacting with the H2 database in a non-blocking manner.

## Features

- **Reactive Programming**. 

- **Spring Boot**. 

- **R2DBC (Reactive Relational Database Connectivity)** : Instead of traditional JDBC, we have opted for R2DBC, which allows us to interact with the H2 database in a reactive way, making data access layer non-blocking.

- **H2 Database** : The project uses the H2 database, a lightweight and in-memory database, as our data store for simplicity and easy setup.

## How to Run the Project

Follow the steps below to run the project locally on your machine:

```bash
git clone https://github.com/farhanatsani/spring-webflux-demo
```
```bash
cd spring-webflux-demo
```
```bash
mvn clean install
```
```bash
mvn spring-boot:run
```

The application should now be up and running on http://localhost:8020.

## Usage and Endpoints

The project exposes several endpoints to demonstrate the usage of reactive programming with R2DBC and H2 database. Here are some of the key endpoints:

Endpoint 1: POST http://localhost:8020/api/cars
            
Request Body:
````
{
    "brand": "Innova",
    "type": "Zenix"
}
````
Endpoint 3: GET http://localhost:8020/api/cars/1

Endpoint 2: GET http://localhost:8020/api/cars
````
Accept: text/event-stream
````