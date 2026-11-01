package ca.keyin.service;

import ca.keyin.entity.City;
import ca.keyin.repository.CityRepository;

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
public class CityServiceTest {

    @Mock
    private CityRepository cityRepository;

    @InjectMocks
    private CityService cityService;

    @Test
    void testGetAllCities() {

        City city1 = new City();
        city1.setName("Toronto");

        City city2 = new City();
        city2.setName("Dubai");

        when(cityRepository.findAll())
                .thenReturn(Arrays.asList(city1, city2));

        List<City> cities = cityService.getAllCities();

        assertEquals(2, cities.size());
        assertEquals("Toronto", cities.get(0).getName());
    }
}
