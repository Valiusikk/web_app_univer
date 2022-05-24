package com.example.demo.service.implementation;

import com.example.demo.dto.InsuranceDTO;
import com.example.demo.entity.Insurance;
import com.example.demo.repository.InsuranceRepository;
import com.example.demo.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private InsuranceRepository repository;

    @Override
    public InsuranceDTO createInsurance(InsuranceDTO clientDTO) {
        return null;
    }

    private Insurance create(InsuranceDTO dto){
        final Insurance insurance =new Insurance();
        insurance.setInsuranceName(dto.getInsuranceName());
        insurance.setCostPerDay(dto.getCostPerDay());
        insurance.setCoverageType(dto.getCoverageType());
        insurance.setInsuranceCode("insurance");

        return insurance;
    }

    @Override
    public InsuranceDTO deleteInsurance(String insuranceName) {
        final Optional<Insurance> insurance =repository.getInsuranceByInsuranceName(insuranceName);
        if(insurance.isPresent()){
            repository.delete(insurance.get());
            return InsuranceDTO.fromInsurance(insurance.get());
        }
        throw new IllegalArgumentException("Insurance does not exist");
    }

    @Override
    public InsuranceDTO updateInsurance(String name,InsuranceDTO insuranceDTO) {
        return null;
    }

    @Override
    public List<InsuranceDTO> getInsurances() {
        return repository.findAll().stream().map(InsuranceDTO::fromInsurance).collect(Collectors.toList());
    }

    @Override
    public InsuranceDTO getInsurance(String name) {
        return InsuranceDTO.fromInsurance(repository.getInsuranceByInsuranceName(name).get());
    }
}
