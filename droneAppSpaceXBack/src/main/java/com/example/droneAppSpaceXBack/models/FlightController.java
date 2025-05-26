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

}