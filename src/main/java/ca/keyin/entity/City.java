package ca.keyin.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.ArrayList;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "City name is required")
    private String name;

    @NotBlank(message = "State is required")
    private String state;

    @NotNull(message = "Population is required")
    @Positive(message = "Population must be greater than zero")
    private Long population;

    @JsonIgnore
    @OneToMany(mappedBy = "city")
    private List<Airport> airports = new ArrayList<>();

    public City() {
    }

    public City(String name, String state, Long population) {
        this.name = name;
        this.state = state;
        this.population = population;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public Long getPopulation() {
        return population;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
