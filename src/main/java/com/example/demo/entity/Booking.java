package com.example.demo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@Entity
@RequiredArgsConstructor
@Table(name = "booking")
public class Booking {
    @Id
    @Column(name = "booking_id")
    private String bookingId;

    @Column(name = "booking_status")
    private String bookingStatus;

    @Column(name = "amount")
    private float amount;

    @Column(name = "pickup_location")
    private String pickupLocation;

    @Column(name = "drop_location")
    private String dropLocation;

    @JoinColumn(name = "registration_number")
    @OneToOne(targetEntity = Car.class)
    private Car car;

    @JoinColumn(name = "client_id")
    @ManyToOne(targetEntity = Client.class)
    private Client client;

    @JoinColumn(name = "discount_code")
    @OneToMany(targetEntity = Discount.class)
    private Set<Discount> discounts;

    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;

    @OneToOne(targetEntity = Insurance.class)
    @JoinColumn(name = "insurance_code")
    private Insurance insurance;
}
