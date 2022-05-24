package com.example.demo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "client")
@RequiredArgsConstructor
public class Client implements UserDetails {

    @Id
    @Column(name = "client_id")
    private UUID id;

    @Column(name = "first_name")
    @NotNull(message = "Client's name must be a valid value")
    @NotBlank(message = "Client's name must be a non blank value")
    private String name;

    @Column(name = "last_name")
    @NotNull(message = "Client's name must be a valid value")
    @NotBlank(message = "Client's name must be a non blank value")
    private String surname;

    @Column(name = "phone_number")
    @NotNull(message = "Client's phone number must be valid")
    @NotBlank(message = "Client's phone number be a non blank value")
    @NotEmpty(message = "Client's phone number should not be an empty string")
    private String phoneNumber;

    @Email
    @Column(name = "email")
    @NotNull(message = "Client's email must be a valid email")
    @NotBlank(message = "Client's email must be a non blank string")
    @NotEmpty(message = "Client's email should not be an empty string")
    private String email;

    @Min(1)
    @Max(5)
    @Column(name = "confidence_factor")
    private int confidenceFactor;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location locationId;

    @Column(name = "role_id")
    private String role;

    @Column(name = "password")
    @NotNull(message = "Client's password must not be null")
    @NotBlank(message = "Client's password must be a non blank string")
    @NotEmpty(message = "Client's password should not be an empty string")
    private String password;

    @JoinColumn(name = "registration_number")
    @OneToMany(targetEntity = Booking.class)
    private Set<Booking> booking;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
