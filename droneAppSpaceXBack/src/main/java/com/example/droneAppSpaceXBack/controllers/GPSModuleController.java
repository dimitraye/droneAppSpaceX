package com.example.droneAppSpaceXBack.controllers;

import com.example.droneAppSpaceXBack.models.GPSModule;
import com.example.droneAppSpaceXBack.services.GPSModuleService;
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
@RequestMapping("/api/gpsmodules")
public class GPSModuleController {

    @Autowired
    private GPSModuleService gpsModuleService;

    // Create gpsModule
    @PostMapping
    public GPSModule createGPSModule(@Validated @RequestBody GPSModule gpsModule) {
        return gpsModuleService.save(gpsModule);
    }

    // Get all gpsModules
    @GetMapping
    public List<GPSModule> getAllGPSModules() {
        return gpsModuleService.findAll();
    }

    // Get gpsModule by ID
    @GetMapping("/{idGPSModule}")
    public ResponseEntity<?> getGPSModuleById(@PathVariable Long idGPSModule) {
        if (idGPSModule == null) {
            return ResponseEntity.badRequest().body("Cannot retrieve gpsModule with null ID");
        }
        Optional<GPSModule> optionalGPSModule = gpsModuleService.findById(idGPSModule);
        if (optionalGPSModule.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("GPSModule not found");
        }
        return ResponseEntity.ok(optionalGPSModule.get());
    }

    // Update gpsModule
    @PutMapping("/{idGPSModule}")
    public ResponseEntity<?> updateGPSModule(@PathVariable Long idGPSModule, @RequestBody GPSModule gpsModuleRequest) {
        Optional<GPSModule> gpsModuleFromDb = gpsModuleService.findById(idGPSModule);

        if (gpsModuleFromDb.isPresent()) {
            GPSModule gpsModule = gpsModuleFromDb.get();

            // Mise à jour des champs (à adapter selon tes besoins)
            gpsModule.setModel(gpsModuleRequest.getModel());
            gpsModule.setLatitude(gpsModuleRequest.getLatitude());
            gpsModule.setLongitude(gpsModuleRequest.getLongitude());
            gpsModule.setAltitude(gpsModuleRequest.getAltitude());
            gpsModule.setFeatures(gpsModuleRequest.getFeatures());
            gpsModule.setGpsPrecision(gpsModuleRequest.getGpsPrecision());
            gpsModule.setGeofencingEnabled(gpsModuleRequest.getGeofencingEnabled());
            gpsModule.setRealTimeTrackingEnabled(gpsModuleRequest.getRealTimeTrackingEnabled());

            gpsModuleService.update(gpsModule);
            return ResponseEntity.ok(Map.of("message", "GPSModule updated successfully!"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "GPSModule not found"));
    }

    // Delete gpsModule
    @DeleteMapping("/{idGPSModule}")
    public ResponseEntity<?> deleteGPSModule(@PathVariable Long idGPSModule) {
        try {
            Optional<GPSModule> gpsModuleFromDb = gpsModuleService.findById(idGPSModule);

            if (gpsModuleFromDb.isPresent()) {
                gpsModuleService.delete(idGPSModule);
                return ResponseEntity.ok(Map.of("message", "GPSModule deleted successfully!"));
            }

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "GPSModule not found"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "An error occurred while deleting the gpsModule"));
        }
    }
}
