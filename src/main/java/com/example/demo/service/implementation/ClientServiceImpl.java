package com.example.demo.service.implementation;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegistrationRequest;
import com.example.demo.entity.Client;
import com.example.demo.entity.Role;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;
import com.example.demo.service.execution.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final BCryptPasswordEncoder encoder;

    private final EmailValidator emailValidator;

    private final static String CLIENT_NOT_FOUND_MESSAGE = "Client with email %s was not found";

    private final ClientRepository repository;


    @Override
    public ClientDTO deleteClient(String email) {
        return null;
    }

    @Override
    public ClientDTO updateClient(String email,ClientDTO clientDTO) {
        return null;
    }

    @Override
    public List<ClientDTO> getClients() {
        return repository.findAll().stream().map(ClientDTO::fromClient).collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClient(String email) {
        return ClientDTO.fromClient(repository.findByEmail(email).orElseThrow(
                ()->new UsernameNotFoundException(String.format(CLIENT_NOT_FOUND_MESSAGE,email))
        ));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email).orElseThrow(
                ()->new UsernameNotFoundException(String.format(CLIENT_NOT_FOUND_MESSAGE,email))
        );
    }

    @Override
    @Transactional
    public ClientDTO register(RegistrationRequest request) {
        emailValidator.validate(request.getEmail());
        final Optional<Client> optionalClient= repository.findByEmail(request.getEmail());
        if(optionalClient.isPresent()){
            throw new RuntimeException("client exists, login please");
        }

        final Client client = createClient(request);

        repository.save(client);

        return ClientDTO.fromClient(client);
    }

    private Client createClient(RegistrationRequest request){
        final Client client = new Client();
        client.setEmail(request.getEmail());
        client.setConfidenceFactor(1);
        client.setRole("User");
        client.setName(request.getName());
        client.setSurname(request.getSurname());
        client.setPhoneNumber(request.getPhoneNumber());
        client.setId(UUID.randomUUID());
        client.setPassword(encoder.encode(request.getPassword()));
        return client;
    }

    @Override
    public ClientDTO login(LoginRequest request) {
        final String email = request.getEmail();
        final String password = request.getPassword();

        Optional<Client> client = repository.findByEmail(email);
        if(client.isPresent()){
            if(encoder.matches(request.getPassword(),client.get().getPassword())){

            }
            else {
                throw new RuntimeException(String.format(CLIENT_NOT_FOUND_MESSAGE,email));
            }
        }

        throw new RuntimeException();

    }
}
