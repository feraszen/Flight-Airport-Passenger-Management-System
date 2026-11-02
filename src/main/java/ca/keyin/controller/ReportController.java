package ca.keyin.controller;

import ca.keyin.entity.City;
import ca.keyin.entity.Flight;
import ca.keyin.entity.Passenger;
import ca.keyin.repository.CityRepository;
import ca.keyin.repository.FlightRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final CityRepository cityRepository;
    private final FlightRepository flightRepository;

    public ReportController(CityRepository cityRepository,
                            FlightRepository flightRepository) {
        this.cityRepository = cityRepository;
        this.flightRepository = flightRepository;
    }

    @GetMapping("/airports-by-city")
    public Map<String, List<String>> getAirportsByCity() {

        Map<String, List<String>> result = new LinkedHashMap<>();

        for (City city : cityRepository.findAll()) {

            result.put(
                    city.getName(),
                    city.getAirports()
                            .stream()
                            .map(airport -> airport.getCode())
                            .collect(Collectors.toList())
            );
        }

        return result;
    }

    @GetMapping("/aircraft-by-passenger")
    public Map<String, List<String>> getAircraftByPassenger() {

        Map<String, List<String>> result = new LinkedHashMap<>();

        for (Flight flight : flightRepository.findAll()) {

            for (Passenger passenger : flight.getPassengers()) {

                String passengerName =
                        passenger.getFirstName() + " "
                                + passenger.getLastName();

                result.putIfAbsent(passengerName, new ArrayList<>());

                String aircraftType =
                        flight.getAircraft().getType();

                if (!result.get(passengerName).contains(aircraftType)) {
                    result.get(passengerName).add(aircraftType);
                }
            }
        }

        return result;
    }

    @GetMapping("/airports-by-aircraft")
    public Map<String, List<String>> getAirportsByAircraft() {

        Map<String, List<String>> result = new LinkedHashMap<>();

        for (Flight flight : flightRepository.findAll()) {

            String aircraftType =
                    flight.getAircraft().getType();

            result.putIfAbsent(aircraftType, new ArrayList<>());

            String departureCode =
                    flight.getDepartureAirport().getCode();

            String arrivalCode =
                    flight.getArrivalAirport().getCode();

            if (!result.get(aircraftType).contains(departureCode)) {
                result.get(aircraftType).add(departureCode);
            }

            if (!result.get(aircraftType).contains(arrivalCode)) {
                result.get(aircraftType).add(arrivalCode);
            }
        }

        return result;
    }

    @GetMapping("/airports-used-by-passenger")
    public Map<String, List<String>> getAirportsUsedByPassenger() {

        Map<String, List<String>> result = new LinkedHashMap<>();

        for (Flight flight : flightRepository.findAll()) {

            String departureCode =
                    flight.getDepartureAirport().getCode();

            String arrivalCode =
                    flight.getArrivalAirport().getCode();

            for (Passenger passenger : flight.getPassengers()) {

                String passengerName =
                        passenger.getFirstName() + " "
                                + passenger.getLastName();

                result.putIfAbsent(passengerName, new ArrayList<>());

                if (!result.get(passengerName).contains(departureCode)) {
                    result.get(passengerName).add(departureCode);
                }

                if (!result.get(passengerName).contains(arrivalCode)) {
                    result.get(passengerName).add(arrivalCode);
                }
            }
        }

        return result;
    }
}
