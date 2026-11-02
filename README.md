# Flight & Airport Management System

## SDATDEVOPS Midterm Project

### Team Members

- Feras Zen Alabdeen
- Darrell Declaro

---

# Project Overview

Flight & Airport Management System is a two-part distributed application designed to manage and analyze flight network data.

The system consists of:

```text
Part 1 - Flight Network API (Spring Boot REST API)
Part 2 - Flight Network CLI (Java Command Line Client)
```

The API manages data storage, business logic, reporting, validation, pagination, sorting, and database integration.

The CLI retrieves information through HTTP requests and presents reports to users through an interactive console interface.

---

# Project Architecture

```text
CLI Application
       │
       ▼
REST API (Spring Boot)
       │
       ▼
MySQL Database
```

---

# Project Structure

```text
Flight-Airport-Passenger-Management-System
│
├── flight-network-api
│
└── flight-network-cli
```

---

# Running the System

## Start the API

```bash
cd flight-network-api
mvn spring-boot:run
```

Verify:

```text
http://localhost:8080
```

---

## Start the CLI

Open a second terminal:

```bash
cd flight-network-cli
mvn exec:java -Dexec.mainClass="org.keyin.Main"
```

The CLI connects to:

```text
http://localhost:8080
```

by default.

---

# Part 1 – Flight Network API

## Technologies

```text
Java 21
Spring Boot 3.5.6
Spring Data JPA
Hibernate
MySQL
Maven
JUnit 5
Mockito
Postman
```

---

## Core Entities

### City

```text
id
name
state
population
```

### Airport

```text
id
name
code
city
```

### Passenger

```text
id
firstName
lastName
phoneNumber
city
```

### Aircraft

```text
id
type
airlineName
numberOfPassengers
```

### Flight

```text
id
departureAirport
arrivalAirport
aircraft
passengers
```

---

## Relationships

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

## CRUD Operations

Implemented for:

```text
City
Airport
Passenger
Aircraft
Flight
```

Supported operations:

```http
GET
GET BY ID
POST
PUT
DELETE
```

---

## Reporting Endpoints

### Airports by City

```http
GET /api/reports/airports-by-city
```

### Aircraft by Passenger

```http
GET /api/reports/aircraft-by-passenger
```

### Airports by Aircraft

```http
GET /api/reports/airports-by-aircraft
```

### Airports Used by Passenger

```http
GET /api/reports/airports-used-by-passenger
```

---

## Pagination & Sorting

Implemented for:

```http
/api/cities/paged
/api/airports/paged
/api/passengers/paged
/api/aircraft/paged
/api/flights/paged
```

Examples:

```http
GET /api/passengers/paged?page=0&size=2
```

```http
GET /api/passengers/paged?page=0&size=3&sortBy=lastName&direction=desc
```

---

## Validation

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

---

## Exception Handling

Implemented:

```text
ResourceNotFoundException
GlobalExceptionHandler
```

Examples:

```http
404 Not Found
```

```http
400 Bad Request
```

---

## API Testing

Implemented Service Tests:

```text
CityServiceTest
AirportServiceTest
PassengerServiceTest
AircraftServiceTest
FlightServiceTest
```

Result:

```text
Tests run: 5
Failures: 0
Errors: 0
BUILD SUCCESS
```

---

# Part 2 – Flight Network CLI

## Technologies

```text
Java 21
Maven
Java HTTP Client
Gson
JUnit 5
Mockito
GitHub Actions
```

---

## CLI Features

```text
✓ Airports by City
✓ Aircraft by Passenger
✓ Airports by Aircraft
✓ Airports Used by Passenger
✓ View History
✓ Previous Record
```

---

## CLI Menu

```text
1. Airports by City
2. Aircraft by Passenger
3. Airports by Aircraft
4. Airports Used by Passenger
5. View History
6. Previous Record
0. Exit
```

---

## History Support

The application records:

```text
Question Number
Report Title
Timestamp
```

---

## CLI Testing

Implemented:

```text
ApiClientTest
HistoryManagerTest
ReportServiceTest
ConsolePrinterTest
MainMenuTest
```

Result:

```text
Tests run: 35
Failures: 0
Errors: 0
BUILD SUCCESS
```

---

# Integration Testing

Verified workflow:

```text
CLI
 ↓
REST API
 ↓
MySQL
```

Successfully tested:

```text
Airports by City
Aircraft by Passenger
Airports by Aircraft
Airports Used by Passenger
View History
Previous Record
```

---

# Sample Flight Scenario

### Flight 1

```text
DXB → FRA
Ahmed Ali
Emirates Airbus A320
```

### Flight 2

```text
FRA → YYZ
Ahmed Ali
Sara Khan
Lufthansa Airbus A321
```

### Flight 3

```text
YYZ → DXB
Omar Hassan
Air Canada Boeing 737 MAX
```

### Flight 4

```text
DXB → YYZ
Omar Hassan
Emirates Airbus A320
```

---

# Project Management

The project uses:

```text
GitHub Project Board
Feature Branches
Pull Requests
GitHub Actions
```

Workflow:

```text
feature/*
      ↓
   develop
      ↓
     main
```

---

# Screenshots

API Screenshots:

```text
flight-network-api/docs/screenshots/
```

CLI Screenshots:

```text
flight-network-cli/docs/images/
```

---

# Postman Collection

```text
flight-network-api/docs/postman/FlightNetwork.postman_collection.json
```

---

# Documentation

```text
flight-network-api/REFLECTION_API.md
flight-network-cli/READMEPART2.md
```

---

# Repositories

## Original Development Repositories

### API Repository

```text
https://github.com/feraszen/Flight-Management-CLI
```

### CLI Repository

```text
https://github.com/dralodrec/flight-network-cli
```

## Final Submission Repository

```text
https://github.com/feraszen/Flight-Airport-Passenger-Management-System
```

---

# Final Status

```text
Part 1 – API                ✅ Complete
Part 2 – CLI                ✅ Complete
Integration Testing         ✅ Complete
Documentation               ✅ Complete
Testing                     ✅ Complete
Project Management          ✅ Complete

Ready for Submission ✅
```