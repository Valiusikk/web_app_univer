package com.example.demo.repository;

import com.example.demo.entity.CarCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarCategRepository extends JpaRepository<CarCategory,String> {
   Optional<CarCategory> findByCarCategory(String category);
}
