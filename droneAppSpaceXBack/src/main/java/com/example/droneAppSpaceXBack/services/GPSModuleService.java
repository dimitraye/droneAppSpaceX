package com.example.droneAppSpaceXBack.services;

import com.example.droneAppSpaceXBack.models.GPSModule;
import com.example.droneAppSpaceXBack.repositories.IGPSModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GPSModuleService {

    @Autowired
    private IGPSModuleRepository gpsModuleRepository;

    // Create
    public GPSModule save(GPSModule gpsModule) {
        return gpsModuleRepository.save(gpsModule);
    }

    // Read one by id
    public Optional<GPSModule> findById(Long id) {
        return gpsModuleRepository.findById(id);
    }

    // Read all
    public List<GPSModule> findAll() {
        return gpsModuleRepository.findAll();
    }

    // Update (save peut aussi faire update si l'id existe)
    public GPSModule update(GPSModule gpsModule) {
        // Optionnel: vérifier si le gpsModule existe avant update
        if (gpsModule.getId() == null || !gpsModuleRepository.existsById(gpsModule.getId())) {
            throw new RuntimeException("GPSModule not found with id " + gpsModule.getId());
        }
        return gpsModuleRepository.save(gpsModule);
    }

    // Delete by id
    public void delete(Long id) {
        gpsModuleRepository.deleteById(id);
    }
}
