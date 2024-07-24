package com.app.bookingService.repository;

import com.app.bookingService.entity.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking,Long> {
}
