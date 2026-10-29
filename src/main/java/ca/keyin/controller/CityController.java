package ca.keyin.controller;

import ca.keyin.entity.City;
import ca.keyin.service.CityService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/paged")
    public Page<City> getCitiesPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return cityService.getCities(pageable);
    }

    @GetMapping("/{id}")
    public Optional<City> getCityById(@PathVariable Long id) {
        return cityService.getCityById(id);
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable Long id,
                           @RequestBody City city) {

        city.setId(id);

        return cityService.saveCity(city);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}

