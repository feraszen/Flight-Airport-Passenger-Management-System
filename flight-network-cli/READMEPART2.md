# SDATDEVOPS Midterm Project
# Part 1 API Completion & Part 2 CLI Handoff

## Overview

Part 1 (Spring Boot REST API) has been completed, tested, documented, and integrated with MySQL.

Repository:

```text
https://github.com/feraszen/Flight-Management-CLI.git
```

The API is fully operational and ready for CLI integration.

---

# Technologies Used

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
GitHub Projects
```

---

# API Status

## Completed Features

### Core Entities

```text
City
Airport
Passenger
Aircraft
Flight
```

### Entity Relationships

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

These endpoints were created specifically for Part 2 (CLI Client).

## Question 1

### Airports By City

```http
GET /api/reports/airports-by-city
```

Example Response:

```json
{
  "Toronto": ["YYZ"],
  "Dubai": ["DXB"],
  "Frankfurt": ["FRA"]
}
```

---

## Question 2

### Aircraft By Passenger

```http
GET /api/reports/aircraft-by-passenger
```

Example Response:

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

## Question 3

### Airports By Aircraft

```http
GET /api/reports/airports-by-aircraft
```

Example Response:

```json
{
  "Boeing 737": [
    "YYZ",
    "DXB"
  ],
  "Airbus A320": [
    "DXB",
    "FRA",
    "YYZ"
  ],
  "Airbus A321": [
    "FRA",
    "YYZ"
  ]
}
```

---

## Question 4

### Airports Used By Passenger

```http
GET /api/reports/airports-used-by-passenger
```

Example Response:

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

# Current Flight Scenario

The following scenario is implemented in the API and should be assumed by the CLI:

```text
DXB -> FRA
Passenger:
Ahmed

Aircraft:
Emirates Airbus A320
```

```text
FRA -> YYZ
Passengers:
Ahmed + Sara

Aircraft:
Lufthansa Airbus A321
```

```text
YYZ -> DXB
Passenger:
Omar

Aircraft:
Air Canada Boeing 737
```

```text
DXB -> YYZ
Passenger:
Omar

Aircraft:
Emirates Airbus A320
```

All passengers currently live in:

```text
Toronto
```

---

# Pagination and Sorting

Implemented and tested.

## Cities

```http
GET /api/cities/paged
```

## Airports

```http
GET /api/airports/paged
```

## Passengers

```http
GET /api/passengers/paged
```

## Aircraft

```http
GET /api/aircraft/paged
```

## Flights

```http
GET /api/flights/paged
```

### Examples

```http
?page=0&size=2
```

```http
?page=0&size=5&sortBy=name
```

```http
?page=0&size=5&sortBy=name&direction=desc
```

---

# Validation

Validation is implemented using:

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

Example:

```http
POST /api/cities
```

Invalid Body:

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

---

# Testing

Implemented:

```text
CityServiceTest
AirportServiceTest
PassengerServiceTest
AircraftServiceTest
FlightServiceTest
```

Current Result:

```text
Tests run: 5
Failures: 0
Errors: 0
BUILD SUCCESS
```

---

# Postman Collection

Available at:

```text
docs/postman/FlightNetwork.postman_collection.json
```

---

# Screenshots

Available at:

```text
docs/screenshots/
```

Including:

```text
Report Endpoints
Pagination
Sorting
Project Board
Collection Runner
```

---

# Project Management

GitHub Project Board, Branches, and Pull Requests were used.

Branching workflow:

```text
feature/*
      ↓
   develop
      ↓
     main
```

Part 1 has been merged into:

```text
main
```

through Pull Requests.

---

# Part 2 Responsibilities

Create a separate Maven project:

```text
flight-network-cli
```

Suggested Structure:

```text
src/main/java/ca/keyin/

Main.java

client/
└── ApiClient.java

service/
├── Question1Service.java
├── Question2Service.java
├── Question3Service.java
└── Question4Service.java

history/
├── HistoryManager.java
└── PreviousRecordManager.java

output/
└── ConsolePrinter.java
```

---

# CLI Requirements

The CLI must consume ONLY:

```http
GET /api/reports/airports-by-city

GET /api/reports/aircraft-by-passenger

GET /api/reports/airports-by-aircraft

GET /api/reports/airports-used-by-passenger
```

DO NOT consume:

```http
/api/cities
/api/airports
/api/passengers
/api/aircraft
/api/flights
```

These are API management endpoints only.

---

# Required Main Menu

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

# Do Not Modify

Please do NOT modify:

```text
Entities
Repositories
Services
Controllers
Database Structure
Report Endpoints
```

The API has been completed and tested.

The CLI should focus only on:

```text
HTTP Requests
Console Output
History Tracking
JUnit Tests
Mockito Tests
GitHub Actions
```

---

# API Base URL

```text
http://localhost:8080
```

---

# Current Project Status

```text
Part 1 API: COMPLETE ✅

Ready for CLI Integration ✅
```