# Flight & Airport Management System

## SDATDEVOPS Midterm Project

**Team Members**

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

Implemented for all entities:

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

Example:

```json
{
  "Toronto": ["YYZ"],
  "Dubai": ["DXB"],
  "Frankfurt": ["FRA"]
}
```

---

### Aircraft by Passenger

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

### Airports by Aircraft

```http
GET /api/reports/airports-by-aircraft
```

Example:

```json
{
  "Airbus A320": [
    "DXB",
    "FRA",
    "YYZ"
  ],
  "Airbus A321": [
    "FRA",
    "YYZ"
  ],
  "Boeing 737 MAX": [
    "YYZ",
    "DXB"
  ]
}
```

---

### Airports Used by Passenger

```http
GET /api/reports/airports-used-by-passenger
```

Example:

```json
{
  "Ahmed Ali": [
    "DXB",
    "FRA",
    "YYZ"
  ],
  "Sara Khan": [
    "FRA",
    "YYZ"
  ],
  "Omar Hassan": [
    "YYZ",
    "DXB"
  ]
}
```

---

## Pagination & Sorting

Implemented and tested for:

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

```http
GET /api/airports/paged?page=0&size=3&sortBy=code&direction=desc
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

Validation is enforced for:

```text
City
Airport
Passenger
Aircraft
Flight
```

Example response:

```http
400 Bad Request
```

```json
{
  "error": "Validation failed"
}
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

### Service Tests

```text
CityServiceTest
AirportServiceTest
PassengerServiceTest
AircraftServiceTest
FlightServiceTest
```

Latest Result:

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

## Menu

```text
=================================
 Flight Network CLI
=================================

1. Airports by City
2. Aircraft by Passenger
3. Airports by Aircraft
4. Airports Used by Passenger
5. View History
6. Previous Record
0. Exit
```

---

## CLI Architecture

```text
Main.java

client/
└── ApiClient.java

service/
└── ReportService.java

history/
├── HistoryManager.java
└── ReportRecord.java

ui/
├── MainMenu.java
└── ConsolePrinter.java
```

---

## History Support

The CLI records:

```text
Question Number
Report Title
Timestamp
```

Example:

```text
Viewing History

1. Airports by Aircraft
2. Airports Used by Passenger
```

---

## Previous Record Support

Example:

```text
Previous: Airports by Aircraft
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

The CLI was successfully integrated and tested against the real Spring Boot API.

Verified workflow:

```text
CLI
 ↓
Report Endpoints
 ↓
MySQL Data
```

The following features were verified using the real API:

```text
Airports by City
Aircraft by Passenger
Airports by Aircraft
Airports Used by Passenger
View History
Previous Record
```

---

# Flight Scenario

The project currently uses the following flight scenario.

### Flight 1

```text
DXB → FRA

Passenger:
Ahmed Ali

Aircraft:
Emirates Airbus A320
```

### Flight 2

```text
FRA → YYZ

Passengers:
Ahmed Ali
Sara Khan

Aircraft:
Lufthansa Airbus A321
```

### Flight 3

```text
YYZ → DXB

Passenger:
Omar Hassan

Aircraft:
Air Canada Boeing 737 MAX
```

### Flight 4

```text
DXB → YYZ

Passenger:
Omar Hassan

Aircraft:
Emirates Airbus A320
```

---

# GitHub Project Management

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

# Postman Collection

Available at:

```text
flight-network-api/docs/postman/FlightNetwork.postman_collection.json
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

Included:

```text
Reports
Pagination
Sorting
Validation
CLI Menu
History
Previous Record
Project Board
Pull Requests
Collection Runner
```

---

# Documentation

API Reflection:

```text
flight-network-api/REFLECTION_API.md
```

---

# Repositories

## API Repository

```text
https://github.com/feraszen/Flight-Management-CLI
```

## CLI Repository

```text
https://github.com/dralodrec/flight-network-cli
```

## Project Repository

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
