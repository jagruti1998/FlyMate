package com.app.repository;


import com.app.entity.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightSearchRepository extends MongoRepository<Flight,Long> {


    public List<Flight> findByOriginAndDestinationAndDepartureDateGreaterThanEqualAndAvailableSeatsGreaterThanEqual
            (String origin, String destination, LocalDate localDate, int passengers) ;

}
