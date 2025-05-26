package com.example.droneAppSpaceXBack.services;

import com.example.droneAppSpaceXBack.models.Drone;
import com.example.droneAppSpaceXBack.repositories.IDroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DroneService {

    @Autowired
    private IDroneRepository droneRepository;

    // Create
    public Drone save(Drone drone) {
        return droneRepository.save(drone);
    }

    // Read one by id
    public Optional<Drone> findById(Long id) {
        return droneRepository.findById(id);
    }

    // Read all
    public List<Drone> findAll() {
        return droneRepository.findAll();
    }

    // Update (save peut aussi faire update si l'id existe)
    public Drone update(Drone drone) {
        // Optionnel: vérifier si le drone existe avant update
        if (drone.getId() == null || !droneRepository.existsById(drone.getId())) {
            throw new RuntimeException("Drone not found with id " + drone.getId());
        }
        return droneRepository.save(drone);
    }

    // Delete by id
    public void delete(Long id) {
        droneRepository.deleteById(id);
    }
}
