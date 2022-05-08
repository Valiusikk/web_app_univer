package com.example.demo.service;

import com.example.demo.dto.InsuranceDTO;

import java.util.List;

public interface InsuranceService {
    InsuranceDTO createInsurance(InsuranceDTO clientDTO);
    InsuranceDTO deleteInsurance(String insuranceName);
    InsuranceDTO updateInsurance(String name,InsuranceDTO insuranceDTO);
    List<InsuranceDTO> getInsurances();
    InsuranceDTO getInsurance(String name);
}
