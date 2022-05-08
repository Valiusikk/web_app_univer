package com.example.demo.controller;

import com.example.demo.dto.DiscountDTO;
import com.example.demo.entity.Car;
import com.example.demo.service.DiscountService;
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
@RequestMapping("/discounts")
public class DiscountController {

    private final DiscountService service;

    @PostMapping
    public ResponseEntity<DiscountDTO> createDiscount(@RequestBody DiscountDTO dto) {
        return ResponseEntity.ok(service.createDiscount(dto));
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<DiscountDTO> getDiscount(@PathVariable String name) {
        return ResponseEntity.ok(service.getDiscount(name));
    }

    @GetMapping
    public ResponseEntity<List<DiscountDTO>> getAllDiscounts() {
        return ResponseEntity.ok(service.getDiscounts());
    }

    @PatchMapping(value = "/{name}")
    public ResponseEntity<DiscountDTO> updateDiscount(@PathVariable String name,@RequestBody DiscountDTO dto){
        return ResponseEntity.ok(service.updateDiscount(name,dto));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<DiscountDTO> deleteDiscount(@PathVariable String name){
        return ResponseEntity.ok(service.deleteDiscount(name));
    }
}
