package com.app.controller;


import com.app.model.FlightRequest;
import com.app.model.FlightResponse;
import com.app.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api/flight")
public class FlightController {

    //@Autowired
    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<FlightResponse> createFlight(@RequestBody FlightRequest flightRequest){

        var flight=flightService.createFlight(flightRequest);

        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    //get all the flight details
    @GetMapping
    public ResponseEntity<List<FlightResponse>> getAllFlights(){
        return new ResponseEntity<>(flightService.getAllFlights(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public FlightResponse getAFlightByNumber(@PathVariable("id") String flightNumber){
        return flightService.getFlightByNumber(flightNumber);
    }
}
