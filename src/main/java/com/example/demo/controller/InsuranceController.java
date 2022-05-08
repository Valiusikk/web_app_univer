package com.example.demo.controller;

import com.example.demo.dto.InsuranceDTO;
import com.example.demo.entity.Car;
import com.example.demo.service.InsuranceService;
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
@RequestMapping("/insurance")
public class InsuranceController {
    
    private final InsuranceService service;

    @PostMapping
    public ResponseEntity<InsuranceDTO> createInsurance(@RequestBody InsuranceDTO insurance) {
        return ResponseEntity.ok(service.createInsurance(insurance));
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<InsuranceDTO> getInsurance(@PathVariable String name) {
        return ResponseEntity.ok(service.getInsurance(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<InsuranceDTO>> getAllInsurances() {
        return ResponseEntity.ok(service.getInsurances());
    }

    @PatchMapping
    public ResponseEntity<InsuranceDTO> updateInsurance(@PathVariable String name,@RequestBody InsuranceDTO insurance) {
        return ResponseEntity.ok(service.updateInsurance(name,insurance));
    }

    @DeleteMapping
    public ResponseEntity<InsuranceDTO> deleteInsurance(@PathVariable String name) {
        return ResponseEntity.ok(service.deleteInsurance(name));
    }
}
