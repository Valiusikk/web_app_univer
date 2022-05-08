package com.example.demo.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {

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
