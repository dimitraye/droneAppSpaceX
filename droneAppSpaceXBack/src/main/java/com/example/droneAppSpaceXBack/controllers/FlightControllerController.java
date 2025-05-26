package com.example.droneAppSpaceXBack.controllers;

import com.example.droneAppSpaceXBack.models.FlightController;
import com.example.droneAppSpaceXBack.services.FlightControllerService;
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
@RequestMapping("/api/flightcontrollers")
public class FlightControllerController {

    @Autowired
    private FlightControllerService flightControllerService;

    // Create flightController
    @PostMapping
    public FlightController createFlightController(@Validated @RequestBody FlightController flightController) {
        return flightControllerService.save(flightController);
    }

    // Get all flightControllers
    @GetMapping
    public List<FlightController> getAllFlightControllers() {
        return flightControllerService.findAll();
    }

    // Get flightController by ID
    @GetMapping("/{idFlightController}")
    public ResponseEntity<?> getFlightControllerById(@PathVariable Long idFlightController) {
        if (idFlightController == null) {
            return ResponseEntity.badRequest().body("Cannot retrieve flightController with null ID");
        }
        Optional<FlightController> optionalFlightController = flightControllerService.findById(idFlightController);
        if (optionalFlightController.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("FlightController not found");
        }
        return ResponseEntity.ok(optionalFlightController.get());
    }

    // Update flightController
    @PutMapping("/{idFlightController}")
    public ResponseEntity<?> updateFlightController(@PathVariable Long idFlightController, @RequestBody FlightController flightControllerRequest) {
        Optional<FlightController> flightControllerFromDb = flightControllerService.findById(idFlightController);

        if (flightControllerFromDb.isPresent()) {
            FlightController flightController = flightControllerFromDb.get();

            // Mise à jour des champs (à adapter selon tes besoins)
            flightController.setModel(flightControllerRequest.getModel());
            flightController.setSupportedFlightModes(flightControllerRequest.getSupportedFlightModes());
            flightController.setCurrentSpeed(flightControllerRequest.getCurrentSpeed());
            flightController.setTargetAltitude(flightControllerRequest.getTargetAltitude());
            flightController.setCommandInterpretation(flightControllerRequest.getCommandInterpretation());
            flightController.setAutoStabilizationEnabled(flightControllerRequest.getAutoStabilizationEnabled());
            flightController.setEmergencyReturnEnabled(flightControllerRequest.getEmergencyReturnEnabled());

            flightControllerService.update(flightController);
            return ResponseEntity.ok(Map.of("message", "FlightController updated successfully!"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "FlightController not found"));
    }

    // Delete flightController
    @DeleteMapping("/{idFlightController}")
    public ResponseEntity<?> deleteFlightController(@PathVariable Long idFlightController) {
        try {
            Optional<FlightController> flightControllerFromDb = flightControllerService.findById(idFlightController);

            if (flightControllerFromDb.isPresent()) {
                flightControllerService.delete(idFlightController);
                return ResponseEntity.ok(Map.of("message", "FlightController deleted successfully!"));
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "FlightController not found"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "An error occurred while deleting the flightController"));
        }
    }
}
