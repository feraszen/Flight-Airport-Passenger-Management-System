# Reflection Questions

## Q1

Pagination and sorting were implemented on:

- /api/passengers/paged
- /api/aircraft/paged
- /api/cities/paged
- /api/airports/paged
- /api/flights/paged

Reason:

Pagination improves performance and prevents returning large amounts of data in a single response.

---

## Q2

Postman screenshots are available in:

docs/screenshots/

---

## Q3

Example Pageable usage:

```java
public Page<Passenger> getPassengers(Pageable pageable) {
    return passengerRepository.findAll(pageable);
}
```

Pageable allows Spring Data JPA to automatically handle pagination and sorting.

---

## Q4

List<T>

Returns all records.

Page<T>

Returns records with pagination details including page number, size, total pages and total elements.

Use List<T> for small datasets.

Use Page<T> for large datasets that require pagination.


---

## Future Improvements

During development, report endpoints were initially implemented using names and aircraft types as grouping keys.

Example:

```json
{
  "Ahmed Ali": [
    "Boeing 737"
  ]
}
```

This approach works for the current dataset but may cause collisions if:

- Multiple passengers have the same full name.
- Multiple aircraft share the same aircraft type.
- Multiple cities share the same name.

A more robust approach would be to use DTO objects that include unique identifiers.

Example:

```json
{
  "passengerId": 1,
  "passengerName": "Ahmed Ali",
  "aircraft": [
    "Boeing 737"
  ]
}
```

This enhancement was identified during API review and is recommended for future scalability.
