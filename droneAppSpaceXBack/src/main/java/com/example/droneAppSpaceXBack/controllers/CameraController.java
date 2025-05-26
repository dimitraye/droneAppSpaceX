package com.example.droneAppSpaceXBack.controllers;

import com.example.droneAppSpaceXBack.models.Camera;
import com.example.droneAppSpaceXBack.services.CameraService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/cameras")
public class CameraController {

    @Autowired
    private CameraService cameraService;

    // Create camera
    @PostMapping
    public Camera createCamera(@Validated @RequestBody Camera camera) {
        return cameraService.save(camera);
    }

    // Get all cameras
    @GetMapping
    public List<Camera> getAllCameras() {
        return cameraService.findAll();
    }

    // Get camera by ID
    @GetMapping("/{idCamera}")
    public ResponseEntity<?> getCameraById(@PathVariable Long idCamera) {
        if (idCamera == null) {
            return ResponseEntity.badRequest().body("Cannot retrieve camera with null ID");
        }
        Optional<Camera> optionalCamera = cameraService.findById(idCamera);
        if (optionalCamera.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Camera not found");
        }
        return ResponseEntity.ok(optionalCamera.get());
    }

    // Update camera
    @PutMapping("/{idCamera}")
    public ResponseEntity<?> updateCamera(@PathVariable Long idCamera, @RequestBody Camera cameraRequest) {
        Optional<Camera> cameraFromDb = cameraService.findById(idCamera);

        if (cameraFromDb.isPresent()) {
            Camera camera = cameraFromDb.get();

            // Mise à jour des champs (à adapter selon tes besoins)
            camera.setBrand(cameraRequest.getBrand());
            camera.setZoom(cameraRequest.getZoom());
            camera.setResolution(cameraRequest.getResolution());

            cameraService.update(camera);
            return ResponseEntity.ok(Map.of("message", "Camera updated successfully!"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Camera not found"));
    }

    // Delete camera
    @DeleteMapping("/{idCamera}")
    public ResponseEntity<?> deleteCamera(@PathVariable Long idCamera) {
        try {
            Optional<Camera> cameraFromDb = cameraService.findById(idCamera);

            if (cameraFromDb.isPresent()) {
                cameraService.delete(idCamera);
                return ResponseEntity.ok(Map.of("message", "Camera deleted successfully!"));
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Camera not found"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "An error occurred while deleting the camera"));
        }
    }
}
