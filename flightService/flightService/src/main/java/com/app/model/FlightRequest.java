package com.app.model;

import org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl;

import java.time.LocalDate;

public record FlightRequest (

    String flightNumber,
    String origin,
    String destination,
    LocalDate departureDate,
    LocalDate arrivalDate,
    int totalSeats,
    int availableSeats,
    double amount
){}
