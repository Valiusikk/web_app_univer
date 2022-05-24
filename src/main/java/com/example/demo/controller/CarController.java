package com.example.demo.controller;

import com.example.demo.dto.CarDTO;
import com.example.demo.entity.Car;
import com.example.demo.service.CarService;
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

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CarController {
    
    private final CarService service;

    @PostMapping(value = "/cars")
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO car) {
        return ResponseEntity.ok(service.saveCar(car));
    }

    @GetMapping(value = "/cars")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(service.getCars());
    }

    @GetMapping(value = "/cars/{model}")
    public ResponseEntity<CarDTO> getCar(@PathVariable String model) {
        return ResponseEntity.ok(service.getCar(model));
    }

    @PatchMapping("/cars/{regNumber}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable String regNumber,@RequestBody CarDTO car){
        return ResponseEntity.ok(service.updateCar(regNumber,car));
    }

    @DeleteMapping("/cars/{regNumber}")
    public ResponseEntity<CarDTO> deleteCar(@PathVariable String regNumber){
        return ResponseEntity.ok(service.deleteCar(regNumber));
    }
}
