package com.example.droneAppSpaceXBack.controllers;

import com.example.droneAppSpaceXBack.models.Drone;
import com.example.droneAppSpaceXBack.services.DroneService;
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
@RequestMapping("/api/drones")
public class DroneController {

    @Autowired
    private DroneService droneService;

    // Create drone
    @PostMapping
    public Drone createDrone(@Validated @RequestBody Drone drone) {
        return droneService.save(drone);
    }

    // Get all drones
    @GetMapping
    public List<Drone> getAllDrones() {
        return droneService.findAll();
    }

    // Get drone by ID
    @GetMapping("/{idDrone}")
    public ResponseEntity<?> getDroneById(@PathVariable Long idDrone) {
        if (idDrone == null) {
            return ResponseEntity.badRequest().body("Cannot retrieve drone with null ID");
        }
        Optional<Drone> optionalDrone = droneService.findById(idDrone);
        if (optionalDrone.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Drone not found");
        }
        return ResponseEntity.ok(optionalDrone.get());
    }

    // Update drone
    @PutMapping("/{idDrone}")
    public ResponseEntity<?> updateDrone(@PathVariable Long idDrone, @RequestBody Drone droneRequest) {
        Optional<Drone> droneFromDb = droneService.findById(idDrone);

        if (droneFromDb.isPresent()) {
            Drone drone = droneFromDb.get();

            // Mise à jour des champs (à adapter selon tes besoins)
            drone.setModel(droneRequest.getModel());
            drone.setWeight(droneRequest.getWeight());
            drone.setMaxRange(droneRequest.getMaxRange());
            drone.setBatteryCapacity(droneRequest.getBatteryCapacity());
            drone.setCamera(droneRequest.getCamera());
            drone.setGpsModule(droneRequest.getGpsModule());
            drone.setFlightController(droneRequest.getFlightController());

            droneService.update(drone);
            return ResponseEntity.ok(Map.of("message", "Drone updated successfully!"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Drone not found"));
    }

    // Delete drone
    @DeleteMapping("/{idDrone}")
    public ResponseEntity<?> deleteDrone(@PathVariable Long idDrone) {
        try {
            Optional<Drone> droneFromDb = droneService.findById(idDrone);

            if (droneFromDb.isPresent()) {
                droneService.delete(idDrone);
                return ResponseEntity.ok(Map.of("message", "Drone deleted successfully!"));
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Drone not found"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "An error occurred while deleting the drone"));
        }
    }
}
