package ca.keyin.service;

import ca.keyin.entity.Flight;
import ca.keyin.repository.FlightRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    @Test
    void testGetAllFlights() {

        Flight flight1 = new Flight();
        flight1.setId(1L);

        Flight flight2 = new Flight();
        flight2.setId(2L);

        when(flightRepository.findAll())
                .thenReturn(Arrays.asList(flight1, flight2));

        List<Flight> flights =
                flightService.getAllFlights();

        assertEquals(2, flights.size());
        assertEquals(1L, flights.get(0).getId());
    }
}
