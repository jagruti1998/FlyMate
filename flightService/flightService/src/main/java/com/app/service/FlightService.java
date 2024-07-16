package com.app.service;

import com.app.model.FlightRequest;
import com.app.model.FlightResponse;

import java.util.List;

public interface FlightService {
    FlightResponse createFlight(FlightRequest flightRequest);

    List<FlightResponse> getAllFlights();

    FlightResponse getFlightByNumber(String flightNumber);
}
