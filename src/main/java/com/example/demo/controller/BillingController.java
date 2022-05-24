package com.example.demo.controller;

import com.example.demo.dto.BillingDTO;
import com.example.demo.service.BillingService;
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
import javax.validation.constraints.Email;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carsharing")
public class BillingController {
    
    private final BillingService service;

    @GetMapping( "/billings")
    public ResponseEntity<List<BillingDTO>> getBillings(){
        return ResponseEntity.ok(service.getBillings());
    }

    @GetMapping( "/billings/{email}")
    public ResponseEntity<List<BillingDTO>> getBillings(@Email @PathVariable String email){
        return ResponseEntity.ok(service.getBillings(email));
    }

    @PostMapping( "/billings")
    public ResponseEntity<BillingDTO> createBilling(@Valid @RequestBody BillingDTO billing){
        return ResponseEntity.ok(service.createBilling(billing));
    }

    @DeleteMapping("/billings/{totalAmount}")
    public ResponseEntity<BillingDTO> deleteBilling(@PathVariable float totalAmount){
        return ResponseEntity.ok(service.deleteBilling(totalAmount));
    }

    @PatchMapping("/billings")
    public ResponseEntity<BillingDTO> updateBilling(@Valid @RequestBody BillingDTO billing,@PathVariable float totalAmount){
        return ResponseEntity.ok(service.updateBilling(totalAmount,billing));
    }
}
