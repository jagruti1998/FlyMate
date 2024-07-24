package com.app.bookingService.service;

import java.time.LocalDate;
import java.util.UUID;

import com.app.bookingService.entity.BookingStatus;
import com.app.bookingService.entity.HotelBooking;
import com.app.bookingService.model.BookingRequest;
import com.app.bookingService.model.BookingResponse;
import com.app.bookingService.model.HotelBookingRequest;
import com.app.bookingService.model.HotelBookingResponse;
import com.app.bookingService.repository.HotelBookingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@Qualifier("hotelBookingService")
@RequiredArgsConstructor
public class HotelBookingService implements BookingService {

    private final HotelBookingRepository hotelBookingRepository;

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest) {

        if (!(bookingRequest instanceof HotelBookingRequest)) {
            throw new IllegalArgumentException("Invalid booking type");
        }

        HotelBooking hotelBooking = mapToHotelBooking(bookingRequest);

        // validate Hotel Booking

        hotelBooking = hotelBookingRepository.save(hotelBooking);

        HotelBookingResponse hotelBookingResponse = new HotelBookingResponse();
        BeanUtils.copyProperties(hotelBooking, hotelBookingResponse);

        return hotelBookingResponse;
    }

    private HotelBooking mapToHotelBooking(BookingRequest bookingRequest) {
        HotelBookingRequest hotelBookingRequest = (HotelBookingRequest) bookingRequest;

        HotelBooking hotelBooking = new HotelBooking();

        hotelBooking.setBookingNumber(UUID.randomUUID().toString());
        hotelBooking.setBookingDate(LocalDate.now());

        hotelBooking.setPassengerName(hotelBookingRequest.getPassengerName());
        hotelBooking.setAmount(hotelBookingRequest.getAmount());
        hotelBooking.setPaymentMode(hotelBookingRequest.getPaymentMode().name());
        hotelBooking.setStatus(BookingStatus.CREATED.name());

        hotelBooking.setHotelName(hotelBookingRequest.getHotelName());
        hotelBooking.setCheckInDate(hotelBookingRequest.getCheckInDate());
        hotelBooking.setCheckOutDate(hotelBookingRequest.getCheckOutDate());

        return hotelBooking;
    }

    @Override
    public String reserveSeats(BookingRequest bookingRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reserveBooking'");
    }

}