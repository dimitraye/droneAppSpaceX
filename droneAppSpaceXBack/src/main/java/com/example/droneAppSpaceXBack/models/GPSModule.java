package com.example.droneAppSpaceXBack.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "gps_module")
public class GPSModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250)
    private String model; // ex : "Ublox NEO-M8N", "ZED-F9P", etc.

    private Double latitude;

    private Double longitude;

    private Double altitude;

    @Column(length = 500)
    private String features; // ex: "RTK, geofencing, waypoint navigation"

    @Column(length = 250)
    private String precision; // ex: "1 mètre", "5 cm (RTK)"

    private Boolean geofencingEnabled;

    private Boolean realTimeTrackingEnabled;
}