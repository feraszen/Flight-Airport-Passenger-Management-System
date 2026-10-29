# Flight Network API

## Project Overview

Flight Network API is a Spring Boot REST application used to manage cities, airports, passengers, aircraft, and flights.

The application provides CRUD operations, reporting endpoints, pagination, sorting, exception handling, and MySQL database integration.

---

## Technologies Used

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

## Database

Database Name:

```sql
flight_network
```

Configure database credentials in:

```text
src/main/resources/application.yml
```

Example:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/flight_network
    username: root
    password: root123
```

---

## Running the Application

Compile:

```bash
mvn clean compile
```

Run:

```bash
mvn spring-boot:run
```

API Base URL:

```text
http://localhost:8080
```

---

## Core Entities

- City
- Airport
- Passenger
- Aircraft
- Flight

---

## CRUD Endpoints

### Cities

```http
GET    /api/cities
GET    /api/cities/{id}
POST   /api/cities
PUT    /api/cities/{id}
DELETE /api/cities/{id}
```

### Airports

```http
GET    /api/airports
GET    /api/airports/{id}
POST   /api/airports
PUT    /api/airports/{id}
DELETE /api/airports/{id}
```

### Passengers

```http
GET    /api/passengers
GET    /api/passengers/{id}
POST   /api/passengers
PUT    /api/passengers/{id}
DELETE /api/passengers/{id}
```

### Aircraft

```http
GET    /api/aircraft
GET    /api/aircraft/{id}
POST   /api/aircraft
PUT    /api/aircraft/{id}
DELETE /api/aircraft/{id}
```

### Flights

```http
GET    /api/flights
GET    /api/flights/{id}
POST   /api/flights
PUT    /api/flights/{id}
DELETE /api/flights/{id}
```

---

## Report Endpoints

### Airports By City

```http
GET /api/reports/airports-by-city
```

### Aircraft By Passenger

```http
GET /api/reports/aircraft-by-passenger
```

### Airports By Aircraft

```http
GET /api/reports/airports-by-aircraft
```

### Airports Used By Passenger

```http
GET /api/reports/airports-used-by-passenger
```

---

## Pagination Examples

### Passengers

```http
GET /api/passengers/paged?page=0&size=2
```

```http
GET /api/passengers/paged?page=0&size=3&sortBy=lastName
```

```http
GET /api/passengers/paged?page=0&size=3&sortBy=lastName&direction=desc
```

### Aircraft

```http
GET /api/aircraft/paged?page=0&size=1
```

```http
GET /api/aircraft/paged?page=0&size=2&sortBy=type
```

---

## Exception Handling

The API uses:

```text
ResourceNotFoundException
GlobalExceptionHandler
```

Example:

```http
GET /api/passengers/999
```

Response:

```json
{
  "error": "Passenger not found with id: 999"
}
```

Status:

```http
404 Not Found
```

---

## Testing

Run all tests:

```bash
mvn test
```

Implemented Tests:

- CityServiceTest
- AirportServiceTest
- PassengerServiceTest
- AircraftServiceTest
- FlightServiceTest

Current Test Status:

```text
Tests run: 5
Failures: 0
Errors: 0
BUILD SUCCESS
```

---

## Sample Data

### Cities

- Toronto
- Dubai
- Frankfurt

### Airports

- YYZ
- DXB
- FRA

### Passengers

- Ahmed Ali
- Sara Khan
- Omar Hassan

### Aircraft

- Boeing 737 (Air Canada)
- Airbus A320 (Emirates)

---

## Team Members

- Feras Zen Alabdeen
- Team Partner

---

## Repository

```text
https://github.com/feraszen/Flight-Management-CLI.git
```
