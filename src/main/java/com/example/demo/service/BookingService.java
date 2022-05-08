package com.example.demo.service;


import com.example.demo.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    BookingDTO createBooking(BookingDTO bookingDTO);
    BookingDTO deleteBooking(BookingDTO bookingDTO);
    BookingDTO updateBooking(BookingDTO bookingDTO);
    List<BookingDTO> getBookings();
    List<BookingDTO> getBookings(String name);
}
