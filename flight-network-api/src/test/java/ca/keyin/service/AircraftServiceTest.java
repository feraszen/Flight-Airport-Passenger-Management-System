package ca.keyin.service;

import ca.keyin.entity.Aircraft;
import ca.keyin.repository.AircraftRepository;

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
public class AircraftServiceTest {

    @Mock
    private AircraftRepository aircraftRepository;

    @InjectMocks
    private AircraftService aircraftService;

    @Test
    void testGetAllAircraft() {

        Aircraft aircraft1 = new Aircraft();
        aircraft1.setType("Boeing 737");

        Aircraft aircraft2 = new Aircraft();
        aircraft2.setType("Airbus A320");

        when(aircraftRepository.findAll())
                .thenReturn(Arrays.asList(aircraft1, aircraft2));

        List<Aircraft> aircraft =
                aircraftService.getAllAircraft();

        assertEquals(2, aircraft.size());
        assertEquals("Boeing 737", aircraft.get(0).getType());
    }
}
