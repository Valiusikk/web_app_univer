package com.example.demo.service.implementation;

import com.example.demo.dto.LocationDTO;
import com.example.demo.entity.Location;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository repository;

    @Override
    public LocationDTO createLocation(LocationDTO locationDTO) {
        repository.save(create(locationDTO));
        return locationDTO;
    }

    private Location create(LocationDTO locationDTO){
        final Location location = new Location();
        location.setLocationId(UUID.randomUUID());
        location.setLocationName(locationDTO.getLocationName());
        set(location,locationDTO);

        return location;
    }

    @Override
    public LocationDTO deleteLocation(String locationName) {
        final Location location = repository.findLocationByLocationName(locationName).get();
        repository.delete(location);
        return  LocationDTO.fromLocation(location);
    }

    @Override
    public LocationDTO updateLocation(LocationDTO locationDTO) {
        final Location location = repository.findLocationByLocationName(locationDTO.getLocationName()).get();
        set(location,locationDTO);
        return null;
    }

    private void set(Location location,LocationDTO locationDTO){
        location.setStateName(locationDTO.getStateName());
        location.setStreet(locationDTO.getStreet());
        location.setZipcode(locationDTO.getZipcode());
    }

    @Override
    public List<LocationDTO> getLocations() {
        return repository.findAll().stream().map(LocationDTO::fromLocation).collect(Collectors.toList());
    }

    @Override
    public LocationDTO getLocation(String name) {
        return LocationDTO.fromLocation(repository.findLocationByLocationName(name).get());
    }
}
