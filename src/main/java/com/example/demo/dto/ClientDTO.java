package com.example.demo.dto;

import com.example.demo.entity.Client;
import com.example.demo.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    @NotNull(message = "Client's name must be a valid value")
    @NotBlank(message = "Client's name must be a non blank value")
    private String name;


    @NotNull(message = "Client's name must be a valid value")
    @NotBlank(message = "Client's name must be a non blank value")
    private String surname;


    @NotNull(message = "Client's phone number must be valid")
    @NotBlank(message = "Client's phone number be a non blank value")
    @NotEmpty(message = "Client's phone number should not be an empty string")
    private String phoneNumber;

    @Email
    @NotNull(message = "Client's email must be a valid email")
    @NotBlank(message = "Client's email must be a non blank string")
    @NotEmpty(message = "Client's email should not be an empty string")
    private String email;

    @Min(value = 1,message = "minima value of confidence factor can be 1")
    @Max(value = 5,message = "maximal value of client's confidence factor can be 5")
    private int confidenceFactor;


    private String role;

    @NotNull(message = "Client's password must not be null")
    @NotBlank(message = "Client's password must be a non blank string")
    @NotEmpty(message = "Client's password should not be an empty string")
    private String password;


    public static ClientDTO fromClient(Client client){
        return new ClientDTO(
                client.getUsername(),
                client.getSurname(),
                client.getPhoneNumber(),
                client.getEmail(),
                client.getConfidenceFactor(),
                client.getRole(),
                client.getPassword()
        );
    }
}
