package com.example.demo.service.implementation;

import com.example.demo.dto.CarDTO;
import com.example.demo.entity.Car;
import com.example.demo.entity.CarCategory;
import com.example.demo.repository.CarCategRepository;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private CarRepository repository;

    private CarCategRepository carCategRepository;

    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        final Car car = create(carDTO);
        final Optional<CarCategory> carCategory = carCategRepository.findByCarCategory(carDTO.getCategory().getCarCategory());

        if(carCategory.isPresent()){
            car.setCategory(carCategory.get());
        }
        else {
            car.setCategory(createCategory(carDTO));
        }

        final CarCategory category = createCategory(carDTO);
        category.setCarCategory(carDTO.getCategory().getCarCategory());

        return carDTO;
    }

    private CarCategory createCategory(CarDTO carDTO){
        final CarCategory category = new CarCategory();
        category.setCarCategory(carDTO.getCategory().getCarCategory());
        category.setSeatsNumber(carDTO.getCategory().getSeatsNumber());
        category.setCostPerDay(carDTO.getCategory().getCostPerDay());
        category.setLuggageAmount(carDTO.getCategory().getLuggageAmount());

        return category;
    }

    private Car create(CarDTO carDTO){
        final Car car = new Car();
        car.setMileage(carDTO.getMileage());
        car.setModelName(carDTO.getModelName());
        car.setModelYear(carDTO.getModelYear());
        car.setRegistrationNumber(carDTO.getRegistrationNumber());
        return car;
    }

    @Override
    public CarDTO deleteCar(String regNum) {
        return null;
    }

    @Override
    public CarDTO updateCar(String regNum,CarDTO car) {
        return null;
    }

    @Override
    public CarDTO getCar(String modelName) {
        return CarDTO.fromCar(repository.findByModelName(modelName).get());
    }

    @Override
    public List<CarDTO> getCars() {
        return repository.findAll().stream().map(CarDTO::fromCar).collect(Collectors.toList());
    }

}
