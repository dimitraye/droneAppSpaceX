package com.example.droneAppSpaceXBack.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "flight_controller")
public class FlightController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250)
    private String model; // ex: "Pixhawk", "Betaflight F7"

    @Column(length = 500)
    private String supportedFlightModes; // ex: "Manual, GPS Hold, Waypoint, Return to Home"

    private Double currentSpeed;

    private Double targetAltitude;

    @Column(length = 500)
    private String commandInterpretation; // info complémentaire ou notes

    private Boolean autoStabilizationEnabled;

    private Boolean emergencyReturnEnabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSupportedFlightModes() {
        return supportedFlightModes;
    }

    public void setSupportedFlightModes(String supportedFlightModes) {
        this.supportedFlightModes = supportedFlightModes;
    }

    public Double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(Double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Double getTargetAltitude() {
        return targetAltitude;
    }

    public void setTargetAltitude(Double targetAltitude) {
        this.targetAltitude = targetAltitude;
    }

    public String getCommandInterpretation() {
        return commandInterpretation;
    }

    public void setCommandInterpretation(String commandInterpretation) {
        this.commandInterpretation = commandInterpretation;
    }

    public Boolean getAutoStabilizationEnabled() {
        return autoStabilizationEnabled;
    }

    public void setAutoStabilizationEnabled(Boolean autoStabilizationEnabled) {
        this.autoStabilizationEnabled = autoStabilizationEnabled;
    }

    public Boolean getEmergencyReturnEnabled() {
        return emergencyReturnEnabled;
    }

    public void setEmergencyReturnEnabled(Boolean emergencyReturnEnabled) {
        this.emergencyReturnEnabled = emergencyReturnEnabled;
    }
}