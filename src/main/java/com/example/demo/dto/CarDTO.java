package com.example.demo.dto;

import com.example.demo.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private String registrationNumber;

    private String modelName;

    private int modelYear;

    private int mileage;

    private CarCategoryDTO category;

    public static CarDTO fromCar(Car car) {
        return new CarDTO(
                car.getRegistrationNumber(),
                car.getModelName(),
                car.getModelYear(),
                car.getMileage(),
                CarCategoryDTO.fromCarCategory(car.getCategory())
        );
    }
}
