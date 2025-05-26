package com.example.droneAppSpaceXBack.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "camera")
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resolution; // ex: "4K", "1080p", etc.

    private String brand; //Sony, Nicon, Samsung, etc.

    private Double zoom; // zoom optique numérique

    public Long getId() {
        return id;
    }
}