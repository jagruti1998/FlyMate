package com.app.repository;

import com.app.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight,Long> {
    Optional<Flight> findByFlightNumber(String flightNumber);
}
