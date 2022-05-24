package com.example.demo.controller;

import com.example.demo.dto.BookingDTO;
import com.example.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carsharing")
public class BookingController {

    private BookingService service;

    @GetMapping(value = "/bookings/{clientID}")
    public ResponseEntity<List<BookingDTO>> getBooking(@PathVariable String name) {
        return ResponseEntity.ok(service.getBookings(name));
    }

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        return ResponseEntity.ok(service.getBookings());
    }

    @DeleteMapping
    public ResponseEntity<BookingDTO> deleteBooking(@RequestBody BookingDTO booking){
        return ResponseEntity.ok(service.deleteBooking(booking));
    }

    @PatchMapping
    public ResponseEntity<BookingDTO> updateBooking(@RequestBody BookingDTO booking){
        return ResponseEntity.ok(service.updateBooking(booking));
    }
}
