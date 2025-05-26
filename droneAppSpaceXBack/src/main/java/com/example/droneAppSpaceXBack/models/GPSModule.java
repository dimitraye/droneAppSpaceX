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
    private String gpsPrecision; // ex: "1 mètre", "5 cm (RTK)"

    private Boolean geofencingEnabled;

    private Boolean realTimeTrackingEnabled;

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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getGpsPrecision() {
        return gpsPrecision;
    }

    public void setGpsPrecision(String gpsPrecision) {
        this.gpsPrecision = gpsPrecision;
    }

    public Boolean getGeofencingEnabled() {
        return geofencingEnabled;
    }

    public void setGeofencingEnabled(Boolean geofencingEnabled) {
        this.geofencingEnabled = geofencingEnabled;
    }

    public Boolean getRealTimeTrackingEnabled() {
        return realTimeTrackingEnabled;
    }

    public void setRealTimeTrackingEnabled(Boolean realTimeTrackingEnabled) {
        this.realTimeTrackingEnabled = realTimeTrackingEnabled;
    }
}