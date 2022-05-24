package com.example.demo.controller;

import com.example.demo.dto.BookingDTO;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.service.BookingService;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthenticationController {

    private final ClientService service;

    private final BookingService bookingService;


    @PostMapping("/register")
    public String register(@ModelAttribute RegistrationRequest request){
        service.register(request);
        return "redirect:/index";
    }

    @PostMapping(value = "/bookings")
    public String createBooking(@ModelAttribute("booking") BookingDTO booking) {
        bookingService.createBooking(booking);
        return "redirect:/index";
    }


}
