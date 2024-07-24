package com.app.bookingService.repository;

import com.app.bookingService.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long>{
}
