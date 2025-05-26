package com.example.droneAppSpaceXBack.repositories;

import com.example.droneAppSpaceXBack.models.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDroneRepository extends JpaRepository<Drone, Long> {
}
