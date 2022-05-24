package com.example.demo.service;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegistrationRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface ClientService extends UserDetailsService {
    ClientDTO deleteClient(String clientName);
    ClientDTO updateClient(String email,ClientDTO clientDTO);
    List<ClientDTO> getClients();
    ClientDTO getClient(String email);
    ClientDTO register(RegistrationRequest request);
    ClientDTO login(LoginRequest request);
}
