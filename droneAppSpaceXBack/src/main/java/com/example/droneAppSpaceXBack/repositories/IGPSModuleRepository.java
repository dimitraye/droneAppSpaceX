package com.example.droneAppSpaceXBack.repositories;


import com.example.droneAppSpaceXBack.models.GPSModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGPSModuleRepository extends JpaRepository<GPSModule, Long> {
}
