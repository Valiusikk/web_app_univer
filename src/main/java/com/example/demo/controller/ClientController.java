package com.example.demo.controller;


import com.example.demo.dto.ClientDTO;
import com.example.demo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carsharing")
public class ClientController {

    private ClientService service;


    @PatchMapping(value = "/clients/{email}")
    public ResponseEntity<ClientDTO> updateClient(@RequestBody ClientDTO dto, @Email @PathVariable String email){
        return ResponseEntity.ok(service.updateClient(email,dto));
    }

    @DeleteMapping(value = "/clients/{email}")
    public ResponseEntity<ClientDTO> deleteClient(@Email @PathVariable String email){
        return ResponseEntity.ok(service.deleteClient(email));
    }

    @GetMapping(value = "/clients/{email}")
    public ResponseEntity<ClientDTO> getClient(@Email @PathVariable String email){
        return ResponseEntity.ok(service.getClient(email));
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<ClientDTO>> getClients(){
        return ResponseEntity.ok(service.getClients());
    }

}
