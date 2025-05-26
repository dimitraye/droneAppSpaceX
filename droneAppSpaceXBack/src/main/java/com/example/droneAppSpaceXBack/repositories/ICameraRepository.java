package com.example.droneAppSpaceXBack.repositories;

import com.example.droneAppSpaceXBack.models.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICameraRepository extends JpaRepository<Camera, Long> {
}
