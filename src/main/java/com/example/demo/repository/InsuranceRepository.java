package com.example.demo.repository;

import com.example.demo.entity.Insurance;
import com.example.demo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, String> {

    Optional<Insurance> getInsuranceByInsuranceName(String name);
}
