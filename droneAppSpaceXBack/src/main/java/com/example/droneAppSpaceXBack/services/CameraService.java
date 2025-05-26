package com.example.droneAppSpaceXBack.services;

import com.example.droneAppSpaceXBack.models.Camera;
import com.example.droneAppSpaceXBack.repositories.ICameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CameraService {

    @Autowired
    private ICameraRepository cameraRepository;

    // Create
    public Camera save(Camera camera) {
        return cameraRepository.save(camera);
    }

    // Read one by id
    public Optional<Camera> findById(Long id) {
        return cameraRepository.findById(id);
    }

    // Read all
    public List<Camera> findAll() {
        return cameraRepository.findAll();
    }

    // Update (save peut aussi faire update si l'id existe)
    public Camera update(Camera camera) {
        // Optionnel: vérifier si le camera existe avant update
        if (camera.getId() == null || !cameraRepository.existsById(camera.getId())) {
            throw new RuntimeException("Camera not found with id " + camera.getId());
        }
        return cameraRepository.save(camera);
    }

    // Delete by id
    public void delete(Long id) {
        cameraRepository.deleteById(id);
    }
}
