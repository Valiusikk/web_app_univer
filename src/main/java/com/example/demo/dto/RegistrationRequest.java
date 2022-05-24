package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class RegistrationRequest {

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

    @NotNull(message = "Client's password must not be null")
    @NotBlank(message = "Client's password must be a non blank string")
    @NotEmpty(message = "Client's password should not be an empty string")
    private String password;
}
