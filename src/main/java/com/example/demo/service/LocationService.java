package com.example.demo.service;

import com.example.demo.dto.LocationDTO;

import java.util.List;

public interface LocationService {
    LocationDTO createLocation(LocationDTO locationDTO);
    LocationDTO deleteLocation(String locationName);
    LocationDTO updateLocation(LocationDTO locationDTO);
    List<LocationDTO> getLocations();
    LocationDTO getLocation(String name);
}
