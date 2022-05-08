package com.example.demo.service.implementation;

import com.example.demo.dto.BookingDTO;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        return null;
    }

    @Override
    public BookingDTO deleteBooking(BookingDTO bookingDTO) {
        return null;
    }

    @Override
    public BookingDTO updateBooking(BookingDTO bookingDTO) {
        return null;
    }

    @Override
    public List<BookingDTO> getBookings() {
        return null;
    }

    @Override
    public List<BookingDTO> getBookings(String name) {
        return null;
    }
}
