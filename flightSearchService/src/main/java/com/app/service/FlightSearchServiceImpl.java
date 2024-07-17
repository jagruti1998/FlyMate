package com.app.service;

import com.app.entity.Flight;
import com.app.model.FlightSearchRequest;
import com.app.model.FlightSearchResponse;
import com.app.repository.FlightSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FlightSearchServiceImpl implements FlightSearchService{

    private final FlightSearchRepository flightSearchRepository;

    public List<FlightSearchResponse> searchFlights(FlightSearchRequest flightSearchRequest) {
        List<Flight> flights = flightSearchRepository
                .findByOriginAndDestinationAndDepartureDateGreaterThanEqualAndAvailableSeatsGreaterThanEqual(
                        flightSearchRequest.origin(),
                        flightSearchRequest.destination(),
                        flightSearchRequest.travelDate(),
                        flightSearchRequest.passengers());

        List<FlightSearchResponse> flightSearchResponseList = flights
                .stream()
                .map(this::mapToFlightSearchResponse)
                .collect(Collectors.toList());

        return flightSearchResponseList;
    }

    private FlightSearchResponse mapToFlightSearchResponse(Flight flight) {
        FlightSearchResponse flightSearchResponse = new FlightSearchResponse();
        BeanUtils.copyProperties(flight, flightSearchResponse);
        return flightSearchResponse;
    }
}