package com.app.service;

import com.app.model.FlightSearchRequest;
import com.app.model.FlightSearchResponse;

import java.util.List;

public interface FlightSearchService {
    public List<FlightSearchResponse> searchFlights(FlightSearchRequest flightSearchRequest);
}
