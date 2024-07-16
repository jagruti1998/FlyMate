package com.app.service;

import com.app.entity.Flight;
import com.app.exception.FlightServiceCustomException;
import com.app.model.FlightRequest;
import com.app.model.FlightResponse;
import com.app.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService{

   // @Autowired
    private final FlightRepository flightRepository;

    @Override
    public FlightResponse createFlight(FlightRequest flightRequest) {


        Flight flight=Flight.builder()
                .flightNumber(flightRequest.flightNumber())
                .origin(flightRequest.origin())
                .destination(flightRequest.destination())
                .departureDate(flightRequest.departureDate())
                .arrivalDate(flightRequest.arrivalDate())
                .totalSeats(flightRequest.totalSeats())
                .availableSeats(flightRequest.availableSeats())
                .amount(flightRequest.amount())
                .build();

        flight=flightRepository.save(flight);

        FlightResponse flightResponse=new FlightResponse();
        BeanUtils.copyProperties(flight ,flightResponse);

        log.info("Flight Created {}", flightResponse.getFlightId());

        return flightResponse;
    }

    @Override
    public List<FlightResponse> getAllFlights() {
        List<Flight>flights=flightRepository.findAll();
        List<FlightResponse> flightResponseList=flights.stream()
                .map(this::mapToFlightResponse)
                .collect(Collectors.toList());

        return flightResponseList;
    }

    @Override
    public FlightResponse getFlightByNumber(String flightNumber) {
        log.info("Get the flight for flight Number: {}",flightNumber);
        Flight optionalFlight=flightRepository.findByFlightNumber(flightNumber)
                .orElseThrow(
                ()-> new FlightServiceCustomException("Flight with given number not found","FLIGHT_NOT_FOUND"));

        FlightResponse flightResponse=new FlightResponse();
        BeanUtils.copyProperties(optionalFlight,flightResponse);
        return flightResponse;

    }

    private FlightResponse mapToFlightResponse(Flight flight){
        FlightResponse flightResponse=new FlightResponse();
        BeanUtils.copyProperties(flight, flightResponse);
        return flightResponse;
    }
}
