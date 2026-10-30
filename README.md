# Flight Network API

## Project Overview

Flight Network API is a Spring Boot REST application designed to manage cities, airports, passengers, aircraft, and flights.

The application provides:

- Full CRUD operations
- Report endpoints for client integration
- Pagination and sorting
- Validation and exception handling
- MySQL database integration
- JUnit and Mockito testing

The API was developed as Part 1 of the SDATDEVOPS Midterm Project.

---

# Technologies Used

- Java 21
- Spring Boot 3.5.6
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- JUnit 5
- Mockito
- Postman

---

# Project Structure

```text
src/main/java/ca/keyin

├── controller
├── dto
├── entity
├── exception
├── repository
├── service
└── FlightNetworkApiApplication.java
```

---

# Database Configuration

Database:

```text
flight_network
```

Configuration:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/flight_network
    username: ${DB_USERNAME:root}
    password: ${DB_PASSWORD:root123}
```

---

# Running the Application

Compile:

```bash
mvn clean compile
```

Run:

```bash
mvn spring-boot:run
```

Run Tests:

```bash
mvn test
```

API Base URL:

```text
http://localhost:8080
```

---

# Core Entities

## City

```text
id
name
state
population
```

## Airport

```text
id
name
code
city
```

## Passenger

```text
id
firstName
lastName
phoneNumber
city
```

## Aircraft

```text
id
type
airlineName
numberOfPassengers
```

## Flight

```text
id
departureAirport
arrivalAirport
aircraft
passengers
```

---

# Entity Relationships

```text
City
  1 -> Many Airport

Passenger
  Many -> 1 City

Flight
  Many -> 1 Aircraft

Flight
  Many -> 1 Departure Airport

Flight
  Many -> 1 Arrival Airport

Flight
  Many <-> Many Passenger
```

---

# CRUD Endpoints

## Cities

```http
GET    /api/cities
GET    /api/cities/{id}
POST   /api/cities
PUT    /api/cities/{id}
DELETE /api/cities/{id}
```

## Airports

```http
GET    /api/airports
GET    /api/airports/{id}
POST   /api/airports
PUT    /api/airports/{id}
DELETE /api/airports/{id}
```

## Passengers

```http
GET    /api/passengers
GET    /api/passengers/{id}
POST   /api/passengers
PUT    /api/passengers/{id}
DELETE /api/passengers/{id}
```

## Aircraft

```http
GET    /api/aircraft
GET    /api/aircraft/{id}
POST   /api/aircraft
PUT    /api/aircraft/{id}
DELETE /api/aircraft/{id}
```

## Flights

```http
GET    /api/flights
GET    /api/flights/{id}
POST   /api/flights
PUT    /api/flights/{id}
DELETE /api/flights/{id}
```

---

# Report Endpoints

These endpoints were specifically created for Part 2 (CLI Client).

## Airports By City

```http
GET /api/reports/airports-by-city
```

Example:

```json
{
  "Toronto": ["YYZ"],
  "Dubai": ["DXB"],
  "Frankfurt": ["FRA"]
}
```

---

## Aircraft By Passenger

```http
GET /api/reports/aircraft-by-passenger
```

Example:

```json
{
  "Ahmed Ali": [
    "Airbus A320",
    "Airbus A321"
  ],
  "Sara Khan": [
    "Airbus A321"
  ],
  "Omar Hassan": [
    "Boeing 737",
    "Airbus A320"
  ]
}
```

---

## Airports By Aircraft

```http
GET /api/reports/airports-by-aircraft
```

---

## Airports Used By Passenger

```http
GET /api/reports/airports-used-by-passenger
```

---

# Pagination

Pagination was implemented for:

```http
GET /api/cities/paged
GET /api/airports/paged
GET /api/passengers/paged
GET /api/aircraft/paged
GET /api/flights/paged
```

## Example

```http
GET /api/passengers/paged?page=0&size=2
```

Response includes:

```json
{
  "totalElements": 3,
  "totalPages": 2
}
```

---

# Sorting

Sorting is supported through:

```http
sortBy
direction
```

Examples:

```http
GET /api/passengers/paged?page=0&size=3&sortBy=lastName
```

```http
GET /api/passengers/paged?page=0&size=3&sortBy=lastName&direction=desc
```

```http
GET /api/airports/paged?page=0&size=3&sortBy=code&direction=desc
```

---

# Validation

Implemented using:

```java
@NotBlank
@NotNull
@NotEmpty
@Positive
@Size
```

Validation exists on:

```text
City
Airport
Passenger
Aircraft
Flight
```

Example Invalid Request:

```json
{
  "name": "",
  "state": "",
  "population": -1
}
```

Response:

```http
400 Bad Request
```

```json
{
  "error": "Validation failed"
}
```

---

# Exception Handling

Implemented:

```text
ResourceNotFoundException
GlobalExceptionHandler
```

Example:

```http
GET /api/passengers/999
```

Response:

```http
404 Not Found
```

```json
{
  "error": "Passenger not found with id: 999"
}
```

---

# Sample Data

## Cities

```text
Toronto
Dubai
Frankfurt
```

## Airports

```text
YYZ
DXB
FRA
```

## Passengers

```text
Ahmed Ali
Sara Khan
Omar Hassan
```

## Aircraft

```text
Boeing 737 (Air Canada)
Airbus A320 (Emirates)
Airbus A321 (Lufthansa)
```

---

# Testing

Implemented Service Tests:

```text
CityServiceTest
AirportServiceTest
PassengerServiceTest
AircraftServiceTest
FlightServiceTest
```

Run:

```bash
mvn test
```

Latest Result:

```text
Tests run: 5
Failures: 0
Errors: 0
BUILD SUCCESS
```

---

# Postman Collection

The exported Postman collection is available at:

```text
docs/postman/FlightNetwork.postman_collection.json
```

---

# Screenshots

Postman screenshots are available at:

```text
docs/screenshots/
```

Included:

```text
report-airports-by-city.png
report-aircraft-by-passenger.png
report-airports-by-aircraft.png
report-airports-used-by-passenger.png
pagination-passengers.png
pagination-aircraft.png
sorting-example.png
```

---

# Reflection Document

Reflection answers are available in:

```text
REFLECTION_API.md
```

---

# Repository

```text
https://github.com/feraszen/Flight-Management-CLI.git
```

---

# Team

- Feras Zen Alabdeen
- Team Partner
