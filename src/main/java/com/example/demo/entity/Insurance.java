package com.example.demo.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "insurance")
@RequiredArgsConstructor
public class Insurance {

    @Id
    @Column(name = "insurance_code")
    private String insuranceCode;

    @Column(name = "insurance_name")
    private String insuranceName;

    @Column(name = "coverage_type")
    private String coverageType;

    @Column(name = "cost_per_day")
    private float costPerDay;

}
