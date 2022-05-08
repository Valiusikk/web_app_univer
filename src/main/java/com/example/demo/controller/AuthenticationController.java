package com.example.demo.controller;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AuthenticationController {

    private final ClientService service;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/registration")
    public ResponseEntity<ClientDTO> register(@RequestBody RegistrationRequest request){
        return ResponseEntity.ok(service.register(request));
    }

}
