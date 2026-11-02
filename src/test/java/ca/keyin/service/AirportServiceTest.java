package ca.keyin.service;

import ca.keyin.entity.Airport;
import ca.keyin.repository.AirportRepository;

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
public class AirportServiceTest {

    @Mock
    private AirportRepository airportRepository;

    @InjectMocks
    private AirportService airportService;

    @Test
    void testGetAllAirports() {

        Airport airport1 = new Airport();
        airport1.setCode("YYZ");

        Airport airport2 = new Airport();
        airport2.setCode("DXB");

        when(airportRepository.findAll())
                .thenReturn(Arrays.asList(airport1, airport2));

        List<Airport> airports =
                airportService.getAllAirports();

        assertEquals(2, airports.size());
        assertEquals("YYZ", airports.get(0).getCode());
    }
}
