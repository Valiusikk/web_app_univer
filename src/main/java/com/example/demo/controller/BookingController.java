package com.example.demo.controller;

import com.example.demo.dto.BookingDTO;
import com.example.demo.entity.Car;
import com.example.demo.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/carsharing")
public class BookingController {

    private BookingService service;

    @PostMapping(value = "/bookings")
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO booking) {
        throw new RuntimeException();
    }

    @GetMapping(value = "/bookings/{clientID}")
    public ResponseEntity<BookingDTO> getBooking(@PathVariable String clientID) {
        throw new RuntimeException();
    }

    @GetMapping(value = "/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        throw new RuntimeException();
    }

    @GetMapping(value = "/cars/{modelName}")
    public ResponseEntity<List<Car>> getDefinedCars(@PathVariable String modelName) {
        throw new RuntimeException();
    }
}
