package ca.keyin.controller;

import ca.keyin.entity.Aircraft;
import ca.keyin.service.AircraftService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;

    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public List<Aircraft> getAllAircraft() {
        return aircraftService.getAllAircraft();
    }

    @GetMapping("/paged")
    public Page<Aircraft> getAircraftPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return aircraftService.getAircraft(pageable);
    }

    @GetMapping("/{id}")
    public Optional<Aircraft> getAircraftById(@PathVariable Long id) {
        return aircraftService.getAircraftById(id);
    }

    @PostMapping
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.saveAircraft(aircraft);
    }

    @PutMapping("/{id}")
    public Aircraft updateAircraft(@PathVariable Long id,
                                   @RequestBody Aircraft aircraft) {

        aircraft.setId(id);

        return aircraftService.saveAircraft(aircraft);
    }

    @DeleteMapping("/{id}")
    public void deleteAircraft(@PathVariable Long id) {
        aircraftService.deleteAircraft(id);
    }
}
