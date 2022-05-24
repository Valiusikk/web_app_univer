package com.example.demo.service;

import com.example.demo.dto.CarCategoryDTO;

import java.util.List;


public interface CarCategoryService {
    CarCategoryDTO createCarCategory(CarCategoryDTO carCategoryDTO);
    CarCategoryDTO deleteCarCategory(String carCategoryName);
    CarCategoryDTO updateCarCategory(String category);
    List<CarCategoryDTO> getCarCategories();
    CarCategoryDTO getCarCategory(String name);
}
