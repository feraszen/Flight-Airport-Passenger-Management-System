package ca.keyin.controller;

import ca.keyin.entity.Passenger;
import ca.keyin.exception.ResourceNotFoundException;
import ca.keyin.service.PassengerService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/paged")
    public Page<Passenger> getPassengersPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return passengerService.getPassengers(pageable);
    }

    @GetMapping("/{id}")
    public Passenger getPassengerById(@PathVariable Long id) {

        return passengerService.getPassengerById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Passenger not found with id: " + id));
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.savePassenger(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id,
                                     @RequestBody Passenger passenger) {

        passenger.setId(id);

        return passengerService.savePassenger(passenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
    }
}
