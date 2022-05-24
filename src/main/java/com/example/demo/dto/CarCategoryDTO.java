package com.example.demo.dto;

import com.example.demo.entity.CarCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarCategoryDTO {

    private String carCategory;

    private String luggageAmount;

    private int seatsNumber;

    private float costPerDay;

    public static CarCategoryDTO fromCarCategory(CarCategory category) {
        return new CarCategoryDTO(
                category.getCarCategory(),
                category.getLuggageAmount(),
                category.getSeatsNumber(),
                category.getCostPerDay()
        );
    }
}
