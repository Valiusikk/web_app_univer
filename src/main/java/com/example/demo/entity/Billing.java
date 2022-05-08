package com.example.demo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@Entity
@RequiredArgsConstructor
@Table(name = "billing")
public class Billing {

    @Id
    @Column(name = "bill_id")
    private UUID billId;

    @Column(name = "bill_date")
    private LocalDate billDate;

    @Column(name = "bill_status")
    private String billStatus;

    @Column(name = "discount_amount")
    private float discountAmount;

    @Column(name = "total_amount")
    private float totalAmount;

    @Column(name = "tax_amount")
    private float taxAmount;

    @OneToOne(targetEntity = Booking.class)
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
