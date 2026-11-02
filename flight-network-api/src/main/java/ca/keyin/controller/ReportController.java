package ca.keyin.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.keyin.entity.Airport;
import ca.keyin.entity.Flight;
import ca.keyin.entity.Passenger;
import ca.keyin.repository.AirportRepository;
import ca.keyin.repository.FlightRepository;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    public ReportController(
            FlightRepository flightRepository,
            AirportRepository airportRepository) {

        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    @GetMapping("/airports-by-city")
    public Map<String, List<String>> getAirportsByCity() {

        Map<String, List<String>> result = new LinkedHashMap<>();

        for (Airport airport : airportRepository.findAll()) {

            String cityName = airport.getCity().getName();

            result.putIfAbsent(cityName, new ArrayList<>());

            if (!result.get(cityName).contains(airport.getCode())) {
                result.get(cityName).add(airport.getCode());
            }
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
