# Flight Network API

## Project Overview

Flight Network API is a Spring Boot REST application designed to manage cities, airports, passengers, aircraft, and flights within a flight network environment.

The application provides:

- Full CRUD operations
- Custom report endpoints for client integration
- Pagination and sorting support
- Input validation and exception handling
- MySQL database integration
- JUnit and Mockito testing

This API was developed as **Part 1** of the SDATDEVOPS Midterm Project and serves as the backend service for the Flight Network CLI application.

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
flight-network-api
│
├── src/
│   ├── main/
│   │   └── java/ca/keyin
│   │       ├── controller
│   │       ├── dto
│   │       ├── entity
│   │       ├── exception
│   │       ├── repository
│   │       ├── service
│   │       └── FlightNetworkApiApplication.java
│   │
│   └── test/
│
├── docs/
│   ├── postman/
│   └── screenshots/
│
├── README.md
├── REFLECTION_API.md
└── pom.xml
```

---

# Database Configuration

Database Name:

```text
flight_network
```

Example Configuration:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/flight_network
    username: ${DB_USERNAME:root}
    password: ${DB_PASSWORD:root123}
```

---

# Running the Application

Compile the project:

```bash
mvn clean compile
```

Run the application:

```bash
mvn spring-boot:run
```

Run tests:

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
 1 → Many Airports

Passenger
 Many → 1 City

Flight
 Many → 1 Aircraft

Flight
 Many → 1 Departure Airport

Flight
 Many → 1 Arrival Airport

Flight
 Many ↔ Many Passengers
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

These report endpoints were specifically created to support the Flight Network CLI client.

## Airports by City

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

## Aircraft by Passenger

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
    "Boeing 737 MAX",
    "Airbus A320"
  ]
}
```

---

## Airports by Aircraft

```http
GET /api/reports/airports-by-aircraft
```

---

## Airports Used by Passenger

```http
GET /api/reports/airports-used-by-passenger
```

---

# Pagination

Pagination has been implemented for:

```http
GET /api/cities/paged
GET /api/airports/paged
GET /api/passengers/paged
GET /api/aircraft/paged
GET /api/flights/paged
```

Example:

```http
GET /api/passengers/paged?page=0&size=2
```

Response:

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

Applied to:

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
Boeing 737 MAX (Air Canada)
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

Run tests:

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

# Project Resources

## Repository

```text
https://github.com/feraszen/flight-network-api
```

## Reflection Document

```text
REFLECTION_API.md
```

## Postman Collection

```text
docs/postman/FlightNetwork.postman_collection.json
```

## Screenshots

```text
docs/screenshots/
```

---

# Screenshots

Available screenshots include:

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

# Repository

https://github.com/feraszen/flight-network-api

---

# Team

- Feras Zen Alabdeen

---

# Final Status

```text
CRUD Operations              ✅ Complete
Report Endpoints             ✅ Complete
Pagination                   ✅ Complete
Sorting                      ✅ Complete
Validation                   ✅ Complete
Exception Handling           ✅ Complete
MySQL Integration            ✅ Complete
Unit Testing                 ✅ Complete
Postman Testing              ✅ Complete
Documentation                ✅ Complete
