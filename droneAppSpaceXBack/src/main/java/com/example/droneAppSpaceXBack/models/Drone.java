package com.example.droneAppSpaceXBack.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "drone")
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250)
    private String model;

    private Double weight; // poids en kg

    private Double maxRange; // portée maximale en km

    private Double batteryCapacity; // capacité batterie en mAh ou Wh

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "camera_id", referencedColumnName = "id")
    private Camera camera;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gps_module_id", referencedColumnName = "id")
    private GPSModule gpsModule;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_controller_id", referencedColumnName = "id")
    private FlightController flightController;


    public Long getId() {
        return id;
    }
}
