package com.example.droneAppSpaceXBack.repositories;

import com.example.droneAppSpaceXBack.models.FlightController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlightControllerRepository extends JpaRepository<FlightController, Long> {
}
