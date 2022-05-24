package com.example.demo.controller;

import com.example.demo.dto.LocationDTO;
import com.example.demo.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class  LocationController {

    private final LocationService service;

    @GetMapping( "/locations")
    public ResponseEntity< List<LocationDTO>> getLocations(){
        return ResponseEntity.ok(service.getLocations());
    }

    @GetMapping( "/locations/{name}")
    public ResponseEntity<LocationDTO> getLocation(@PathVariable String name){
        return ResponseEntity.ok(service.getLocation(name));
    }

    @PostMapping( "/locations")
    public ResponseEntity<LocationDTO> createLocation(@Valid @RequestBody LocationDTO location){
        return ResponseEntity.ok(service.createLocation(location));
    }

    @DeleteMapping("/locations/{name}")
    public ResponseEntity<LocationDTO> deleteLocation(@PathVariable String name){
        return ResponseEntity.ok(service.deleteLocation(name));
    }

    @PatchMapping("/locations")
    public ResponseEntity<LocationDTO> updateLocation(@Valid @RequestBody LocationDTO location){
        return ResponseEntity.ok(service.updateLocation(location));
    }
}
