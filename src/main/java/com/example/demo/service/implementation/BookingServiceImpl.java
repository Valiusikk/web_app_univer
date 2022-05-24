package com.example.demo.service.implementation;

import com.example.demo.dto.BookingDTO;
import com.example.demo.entity.Booking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository repository;

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        final Booking booking = create(bookingDTO);
        repository.save(booking);
        return bookingDTO;
    }

    private Booking create(BookingDTO bookingDTO){
        final Booking booking = new Booking();
        booking.setBookingId(UUID.randomUUID());
        booking.setAmount(booking.getAmount());
        booking.setBookingStatus("Active");
        booking.setDropLocation(bookingDTO.getDropLocation());
        booking.setPickupLocation(booking.getPickupLocation());
        booking.setInsurance(null);
        booking.setEndDateTime(bookingDTO.getStartDateTime());
        booking.setStartDateTime(bookingDTO.getEndDateTime());
        return booking;
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
        return repository.findAll().stream().map(BookingDTO::fromBooking).collect(Collectors.toList());
    }

    @Override
    public List<BookingDTO> getBookings(String name) {
        return null;
    }
}
