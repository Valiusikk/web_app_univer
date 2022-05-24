package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "model_name")
    private String modelName;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "mileage")
    private int mileage;

    @JoinColumn(name = "car_category")
    @ManyToOne(targetEntity = CarCategory.class)
    private CarCategory category;


}
