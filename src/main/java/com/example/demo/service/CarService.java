package com.example.demo.service;


import com.example.demo.dto.CarDTO;

import java.util.List;

public interface CarService {
    CarDTO saveCar(CarDTO car);
    CarDTO deleteCar(String regNumber);
    CarDTO updateCar(String regNum,CarDTO car);
    CarDTO getCar(String modelName);
    List<CarDTO> getCars();
}
