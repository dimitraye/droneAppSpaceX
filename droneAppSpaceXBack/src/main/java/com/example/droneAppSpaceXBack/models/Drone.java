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

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(Double maxRange) {
        this.maxRange = maxRange;
    }

    public Double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public GPSModule getGpsModule() {
        return gpsModule;
    }

    public void setGpsModule(GPSModule gpsModule) {
        this.gpsModule = gpsModule;
    }

    public FlightController getFlightController() {
        return flightController;
    }

    public void setFlightController(FlightController flightController) {
        this.flightController = flightController;
    }
}
