package com.example.demo.controller;


import com.example.demo.dto.ClientDTO;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ClientController {

    private ClientService service;

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(){
        throw new RuntimeException();
    }

    @PatchMapping
    public ResponseEntity<ClientDTO> updateClient(){
        throw new RuntimeException();
    }

    @DeleteMapping
    public ResponseEntity<ClientDTO> deleteClient(){
        throw new RuntimeException();
    }

}
