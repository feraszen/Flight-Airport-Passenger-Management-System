package ca.keyin.service;

import ca.keyin.entity.Passenger;
import ca.keyin.repository.PassengerRepository;

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
public class PassengerServiceTest {

    @Mock
    private PassengerRepository passengerRepository;

    @InjectMocks
    private PassengerService passengerService;

    @Test
    void testGetAllPassengers() {

        Passenger passenger1 = new Passenger();
        passenger1.setFirstName("Ahmed");

        Passenger passenger2 = new Passenger();
        passenger2.setFirstName("Sara");

        when(passengerRepository.findAll())
                .thenReturn(Arrays.asList(passenger1, passenger2));

        List<Passenger> passengers =
                passengerService.getAllPassengers();

        assertEquals(2, passengers.size());
        assertEquals("Ahmed", passengers.get(0).getFirstName());
    }
}
