package com.app.bookingService.model;

import lombok.Data;

@Data
public final class FlightBookingRequest extends BookingRequest{

    private String flightNumber;
}
