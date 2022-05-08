package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "car_category")
public class CarCategory {

    @Id
    @Column(name = "car_category")
    private String carCategory;

    @Column (name = "luggage_amount")
    private String luggageAmount;

    @Column(name = "seats_number")
    private int seatsNumber;

    @Column(name = "cost_per_day")
    private float costPerDay;

}
