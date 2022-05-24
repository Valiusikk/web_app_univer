package com.example.demo.dto;

import com.example.demo.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {
    private String locationName;

    private String street;

    private String zipcode;

    private String stateName;

    public static LocationDTO fromLocation(Location location){
        return new LocationDTO(
                location.getLocationName(),
                location.getStreet(),
                location.getZipcode(),
                location.getStateName()
        );
    }
}
