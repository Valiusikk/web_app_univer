package com.example.demo.service.implementation;

import com.example.demo.dto.CarCategoryDTO;
import com.example.demo.entity.CarCategory;
import com.example.demo.repository.CarCategRepository;
import com.example.demo.service.CarCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarCategoryServiceImpl implements CarCategoryService {

    private final CarCategRepository repository;

    @Override
    public CarCategoryDTO createCarCategory(CarCategoryDTO carCategoryDTO) {
        repository.save(create(carCategoryDTO));
        return carCategoryDTO;
    }

    private CarCategory create(CarCategoryDTO categoryDTO){
        final CarCategory carCategory = new CarCategory();
        carCategory.setCarCategory(categoryDTO.getCarCategory());
        carCategory.setCostPerDay(categoryDTO.getCostPerDay());
        carCategory.setLuggageAmount(carCategory.getLuggageAmount());
        carCategory.setSeatsNumber(categoryDTO.getSeatsNumber());

        return carCategory;
    }

    @Override
    public CarCategoryDTO deleteCarCategory(String carCategoryName) {
        final CarCategory carCategory = repository.findByCarCategory(carCategoryName).orElseThrow(
                ()->new RuntimeException("This car category does not exist")
        );
        repository.delete(carCategory);
        return CarCategoryDTO.fromCarCategory(carCategory);
    }

    @Override
    public CarCategoryDTO updateCarCategory(String category) {
        return null;
    }

    @Override
    public List<CarCategoryDTO> getCarCategories() {
        return repository.findAll().stream().map(CarCategoryDTO::fromCarCategory).collect(Collectors.toList());
    }


    @Override
    public CarCategoryDTO getCarCategory(String name) {
        return CarCategoryDTO.fromCarCategory(repository.findByCarCategory(name).get());
    }
}
