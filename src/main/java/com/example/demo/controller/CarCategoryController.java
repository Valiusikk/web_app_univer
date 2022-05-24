package com.example.demo.controller;

import com.example.demo.dto.CarCategoryDTO;
import com.example.demo.service.CarCategoryService;
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
@RequestMapping("/carsharing")
public class CarCategoryController {
    
    private final CarCategoryService service;

    @PostMapping(value = "/car/categories")
    public ResponseEntity<CarCategoryDTO> createCarCategory(@RequestBody CarCategoryDTO carCategory) {
        return ResponseEntity.ok(service.createCarCategory(carCategory));
    }


    @GetMapping(value = "/cars/categories")
    public ResponseEntity<List<CarCategoryDTO>> getAllCarCategories() {
        return ResponseEntity.ok(service.getCarCategories());
    }

    @GetMapping(value = "/cars/categories/{category}")
    public ResponseEntity<CarCategoryDTO> getAllCarCategories(@PathVariable String category) {
        return ResponseEntity.ok(service.getCarCategory(category));
    }

    @PatchMapping(value = "/cars/categories")
    public ResponseEntity<CarCategoryDTO> updateCarCategory(@PathVariable String category) {
        return ResponseEntity.ok(service.updateCarCategory(category));
    }

    @DeleteMapping(value = "/cars/categories/{category}")
    public ResponseEntity<CarCategoryDTO> deleteCarCategory(@PathVariable String category) {
        return ResponseEntity.ok(service.deleteCarCategory(category));
    }
}
