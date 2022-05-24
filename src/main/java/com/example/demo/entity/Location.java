package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Setter
@Getter
@Table(name = "location")
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @Column(name = "location_id")
    private UUID locationId;

    @Column(name = "LOCATION_NAME")
    private String locationName;

    @Column(name = "street")
    private String street;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "state_name")
    private String stateName;

}
