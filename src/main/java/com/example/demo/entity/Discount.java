package com.example.demo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "discount")
@RequiredArgsConstructor
public class Discount {

    @Id
    @Column(name = "discount_code")
    private String discountCode;

    @Column(name = "discount_name")
    private String discountName;

    @Column(name = "expire_date")
    private LocalDate expireDate;

    @Column(name = "discount_percentage")
    private float discountPercentage;
}
