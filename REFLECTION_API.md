# Reflection Questions

## Q1

### Which endpoints support pagination?

Pagination and sorting were implemented on the following endpoints:

```http
GET /api/passengers/paged
GET /api/aircraft/paged
GET /api/cities/paged
GET /api/airports/paged
GET /api/flights/paged
```

### Why were these endpoints selected?

During development, the project initially contained a small dataset. However, as the number of passengers, flights, airports, and aircraft increases, returning all records in a single response becomes inefficient.

Pagination was implemented to:

- Improve API performance.
- Reduce the amount of data returned in a single request.
- Make the API scalable for larger datasets.
- Improve user experience when browsing records.

Sorting was added to allow users to organize results using fields such as:

```text
id
name
lastName
code
type
```

This makes searching and navigating through large datasets significantly easier.

---

## Q2

### Postman Testing

The API was fully tested using Postman.

Screenshots of API testing are available in:

```text
docs/screenshots/
```

The following features were tested:

### Reports

```http
GET /api/reports/airports-by-city
GET /api/reports/aircraft-by-passenger
GET /api/reports/airports-by-aircraft
GET /api/reports/airports-used-by-passenger
```

### Pagination

```http
GET /api/passengers/paged?page=0&size=2
GET /api/aircraft/paged?page=0&size=1
```

### Sorting

```http
GET /api/passengers/paged?page=0&size=3&sortBy=lastName&direction=desc
```

Example URL used during testing:

```http
GET http://localhost:8080/api/passengers/paged?page=0&size=2
```

Example result:

```json
{
  "totalElements": 3,
  "totalPages": 2,
  "size": 2
}
```

This confirmed that pagination was working correctly.

---

## Q3

### Explain how Pageable is used in your code

Spring Data JPA's `Pageable` interface was used to support pagination and sorting.

Example from PassengerService:

```java
public Page<Passenger> getPassengers(Pageable pageable) {
    return passengerRepository.findAll(pageable);
}
```

Example from PassengerController:

```java
Sort sort = direction.equalsIgnoreCase("desc")
        ? Sort.by(sortBy).descending()
        : Sort.by(sortBy).ascending();

Pageable pageable = PageRequest.of(page, size, sort);

return passengerService.getPassengers(pageable);
```

The API receives:

```text
page
size
sortBy
direction
```

from the request and converts them into a `Pageable` object.

The repository then retrieves only the requested page of records instead of loading the entire table.

This approach reduces data transfer and improves performance.

---

## Q4

### What is the difference between List<T> and Page<T>?

### List<T>

```java
List<Passenger>
```

A `List<T>` only contains records.

Example:

```json
[
  {
    "id": 1,
    "firstName": "Ahmed"
  }
]
```

It does not provide any pagination information.

---

### Page<T>

```java
Page<Passenger>
```

A `Page<T>` contains:

- Records
- Current page number
- Page size
- Total pages
- Total elements
- Sorting information

Example:

```json
{
  "content": [...],
  "totalElements": 3,
  "totalPages": 2,
  "size": 2
}
```

---

### When would I use each?

I use:

```java
List<T>
```

when all records are required and the dataset is small.

Examples in this project:

```java
getAllCities()
getAllAirports()
```

I use:

```java
Page<T>
```

when large datasets may exist and records should be returned in smaller pages.

Examples in this project:

```java
/api/passengers/paged
/api/aircraft/paged
/api/cities/paged
/api/airports/paged
/api/flights/paged
```

Using `Page<T>` makes the API more scalable and efficient for future growth.

---

## Additional Reflection

During implementation, I expanded the original model by introducing a `Flight` entity.

Instead of directly connecting passengers to aircraft, flights are used to represent actual travel routes:

```text
Passenger
    ↓
  Flight
    ↓
 Aircraft
```

This allowed the project to accurately model:

- Departure airports
- Arrival airports
- Aircraft used for each trip
- Passengers assigned to each flight

As a result, the four required report endpoints could be generated using real flight data rather than artificial relationships.

The final implementation provided a more realistic flight network while still satisfying all assignment requirements.
