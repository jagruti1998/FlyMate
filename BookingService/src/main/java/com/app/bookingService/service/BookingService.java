package com.app.bookingService.service;

import com.app.bookingService.model.BookingRequest;
import com.app.bookingService.model.BookingResponse;

public interface BookingService  {
    public BookingResponse createBooking(BookingRequest bookingRequest);

    public String reserveSeats(BookingRequest bookingRequest);
}
