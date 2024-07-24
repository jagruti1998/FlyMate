package com.app.bookingService.model;

import lombok.Data;

@Data
public final class FlightBookingResponse extends BookingResponse{
    private String flightNumber;
}
