package com.example.demo.dto;

import com.example.demo.entity.Insurance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsuranceDTO {

    private String insuranceName;

    private String coverageType;

    private float costPerDay;

    public static InsuranceDTO fromInsurance(Insurance insurance){
        return new InsuranceDTO(
            insurance.getInsuranceName(),
            insurance.getCoverageType(),
            insurance.getCostPerDay()
        );
    }
}
