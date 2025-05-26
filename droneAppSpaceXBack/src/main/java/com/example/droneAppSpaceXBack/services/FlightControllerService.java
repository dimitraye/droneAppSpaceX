package com.example.droneAppSpaceXBack.services;

import com.example.droneAppSpaceXBack.models.FlightController;
import com.example.droneAppSpaceXBack.repositories.IFlightControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightControllerService {

    @Autowired
    private IFlightControllerRepository flightControllerRepository;

    // Create
    public FlightController save(FlightController flightController) {
        return flightControllerRepository.save(flightController);
    }

    // Read one by id
    public Optional<FlightController> findById(Long id) {
        return flightControllerRepository.findById(id);
    }

    // Read all
    public List<FlightController> findAll() {
        return flightControllerRepository.findAll();
    }

    // Update (save peut aussi faire update si l'id existe)
    public FlightController update(FlightController flightController) {
        // Optionnel: vérifier si le flightController existe avant update
        if (flightController.getId() == null || !flightControllerRepository.existsById(flightController.getId())) {
            throw new RuntimeException("FlightController not found with id " + flightController.getId());
        }
        return flightControllerRepository.save(flightController);
    }

    // Delete by id
    public void delete(Long id) {
        flightControllerRepository.deleteById(id);
    }
}
