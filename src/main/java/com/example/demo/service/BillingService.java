package com.example.demo.service;


import com.example.demo.dto.BillingDTO;

import java.util.List;
import java.util.UUID;

public interface BillingService {
    BillingDTO createBilling(BillingDTO billing);
    BillingDTO updateBilling(float amount,BillingDTO billing);
    BillingDTO deleteBilling(float amount);
    BillingDTO getBilling(float amount);
    List<BillingDTO> getBillings(String clientEmail);
    List<BillingDTO> getBillings();
}
