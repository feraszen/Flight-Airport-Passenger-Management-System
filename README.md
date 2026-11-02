# Flight & Airport Management System

## SDATDEVOPS Midterm Project

### Team Members

| Team Member | Contribution |
|------------|-------------|
| Feras Zen Alabdeen | Flight Network API Development, Database Integration, Testing, Documentation |
| Darrell Declaro | Flight Network CLI Development, API Integration, Testing |

---

# Project Overview

Flight & Airport Management System is a distributed Java-based application developed as part of the SDATDEVOPS Midterm Project.

The system consists of two integrated components:

- Part 1 – Flight Network API (Spring Boot REST API)
- Part 2 – Flight Network CLI (Java Command Line Client)

The API manages application data, business logic, reporting, validation, pagination, sorting, and MySQL database integration.

The CLI consumes REST endpoints exposed by the API and presents information through an interactive command-line interface.

---

# System Architecture

```text
┌─────────────────────┐
│ Flight Network CLI  │
└──────────┬──────────┘
           │ HTTP Requests
           ▼
┌─────────────────────┐
│ Flight Network API  │
└──────────┬──────────┘
           │ JPA / Hibernate
           ▼
┌─────────────────────┐
│   MySQL Database    │
└─────────────────────┘
```

---

# Project Structure

```text
Flight-Airport-Passenger-Management-System
│
├── flight-network-api/
│   ├── src/
│   ├── docs/
│   ├── README.md
│   └── REFLECTION_API.md
│
├── flight-network-cli/
│   ├── src/
│   ├── docs/
│   └── READMEPART2.md
│
├── docs/
├── DEMO_VIDEO.md
├── README.md
└── pom.xml
```

---

# Running the System

## Step 1 – Start the API

```bash
cd flight-network-api
mvn spring-boot:run
```

Verify the application is running:

```text
http://localhost:8080
```

Expected output:

```text
Tomcat started on port 8080
Started FlightNetworkApiApplication
```

---

## Step 2 – Start the CLI

Open a second terminal window:

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

## Technologies Used

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

## Entity Relationships

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

## Pagination and Sorting

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

Common responses:

```http
400 Bad Request
404 Not Found
```

---

## API Testing

Implemented service tests:

```text
CityServiceTest
AirportServiceTest
PassengerServiceTest
AircraftServiceTest
FlightServiceTest
```

Results:

```text
Tests run: 5
Failures: 0
Errors: 0
BUILD SUCCESS
```

---

# Part 2 – Flight Network CLI

## Technologies Used

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

Implemented tests:

```text
ApiClientTest
HistoryManagerTest
ReportServiceTest
ConsolePrinterTest
MainMenuTest
```

Results:

```text
Tests run: 35
Failures: 0
Errors: 0
BUILD SUCCESS
```

---

# Integration Testing

The following workflow was successfully verified:

```text
CLI
 ↓
REST API
 ↓
MySQL
```

Successfully tested:

```text
✓ Airports by City
✓ Aircraft by Passenger
✓ Airports by Aircraft
✓ Airports Used by Passenger
✓ View History
✓ Previous Record
```

---

# Sample Flight Scenario

### Flight 1

```text
DXB → FRA
Passenger: Ahmed Ali
Aircraft: Emirates Airbus A320
```

### Flight 2

```text
FRA → YYZ
Passengers: Ahmed Ali, Sara Khan
Aircraft: Lufthansa Airbus A321
```

### Flight 3

```text
YYZ → DXB
Passenger: Omar Hassan
Aircraft: Air Canada Boeing 737 MAX
```

### Flight 4

```text
DXB → YYZ
Passenger: Omar Hassan
Aircraft: Emirates Airbus A320
```

---

# Project Management

The project uses:

```text
GitHub Projects
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

## API Screenshots

```text
flight-network-api/docs/screenshots/
```

## CLI Screenshots

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

## API Documentation

```text
flight-network-api/README.md
flight-network-api/REFLECTION_API.md
```

## CLI Documentation

```text
flight-network-cli/READMEPART2.md
```

## Additional Documentation

```text
docs/
```

---

# Repositories & Documentation

## Final Integrated Project Repository

Flight & Airport Management System (Final Submission)

```text
https://github.com/feraszen/Flight-Airport-Passenger-Management-System
```

---

## Part 1 – Flight Network API

Developer: **Feras Zen Alabdeen**

Repository:

```text
https://github.com/feraszen/flight-network-api
```

Documentation:

```text
flight-network-api/README.md
flight-network-api/REFLECTION_API.md
```

Postman Collection:

```text
flight-network-api/docs/postman/FlightNetwork.postman_collection.json
```

Screenshots:

```text
flight-network-api/docs/screenshots/
```

---

## Part 2 – Flight Network CLI

Developer: **Darrell Declaro**

Repository:

```text
https://github.com/dralodrec/flight-network-cli
```

Documentation:

```text
flight-network-cli/READMEPART2.md
```

Screenshots:

```text
flight-network-cli/docs/images/
```

---

## Additional Project Files

Demo Video Information:

```text
DEMO_VIDEO.md
```

Project Documentation:

```text
docs/
```

Reflection Document:

```text
flight-network-api/REFLECTION_API.md
```

---

# Demo Video

Video documentation and submission details:

```text
DEMO_VIDEO.md
```

---

# Final Status

```text
Part 1 – Flight Network API         ✅ Complete
Part 2 – Flight Network CLI         ✅ Complete

REST API Development               ✅ Complete
CLI Development                    ✅ Complete

Database Integration               ✅ Complete
Report Generation                  ✅ Complete

Pagination & Sorting               ✅ Complete
Validation                         ✅ Complete
Exception Handling                 ✅ Complete

Unit Testing                       ✅ Complete
Integration Testing                ✅ Complete

Documentation                      ✅ Complete
Project Management                 ✅ Complete
