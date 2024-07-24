package com.app.bookingService.external.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


//@CircuitBreaker(name = "external", fallbackMethod = "fallback")
//@FeignClient(name = "flight-service/v1/api/flights")
// , url = "http://flight-service/v1/api/flights")

@FeignClient(name = "flight-service", url = "http://localhost:8082/v1/api/flights")

public interface FlightService {

    @PutMapping("/reserveSeats/{id}")
    public void reserveSeats(@PathVariable("id") String flightNumber,
                             @RequestParam int seats);

    default void fallback(Exception e) {
        throw new BookingException("Flight Service is not available",
                "UNAVAILABLE",
                500);
    }
}