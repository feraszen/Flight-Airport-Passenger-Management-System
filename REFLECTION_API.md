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
