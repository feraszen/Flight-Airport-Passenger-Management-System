package ca.keyin.service;

import ca.keyin.entity.Aircraft;
import ca.keyin.repository.AircraftRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAllAircraft() {
        return aircraftRepository.findAll();
    }

    public Optional<Aircraft> getAircraftById(Long id) {
        return aircraftRepository.findById(id);
    }

    public Aircraft saveAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public void deleteAircraft(Long id) {
        aircraftRepository.deleteById(id);
    }

    public Page<Aircraft> getAircraft(Pageable pageable) {
        return aircraftRepository.findAll(pageable);
    }
}
