package com.example.demo.service.implementation;

import com.example.demo.dto.DiscountDTO;
import com.example.demo.entity.Discount;
import com.example.demo.repository.DiscountRepository;
import com.example.demo.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private DiscountRepository repository;

    @Override
    public DiscountDTO createDiscount(DiscountDTO dto) {
        final Discount discount = create(dto);
        repository.save(discount);
        return dto;
    }

    private Discount create(DiscountDTO dto){
        final Discount discount = new Discount();
        discount.setDiscountCode(discountCodeGenerator());
        discount.setDiscountName(dto.getDiscountName());
        discount.setDiscountPercentage(dto.getDiscountPercentage());
        discount.setExpireDate(dto.getExpireDate());

        return discount;
    }

    private static String discountCodeGenerator(){
        return (int)Math.floor(Math.random()*10000000)+"";
    }

    @Override
    public DiscountDTO deleteDiscount(String discountName) {
        final Optional<Discount> discount =repository.findDiscountByDiscountName(discountName);
        if(discount.isPresent()){
            repository.delete(discount.get());
            return DiscountDTO.fromDiscount(discount.get());
        }
        throw new IllegalArgumentException("Discount not found");
    }

    @Override
    public DiscountDTO updateDiscount(String name,DiscountDTO dto) {
        final Optional<Discount> discount =repository.findDiscountByDiscountName(name);
        if(discount.isEmpty()){
            throw new IllegalArgumentException("Discount not found");
        }
        final Discount discountToChange = discount.get();
        discountToChange.setDiscountName(dto.getDiscountName());
        discountToChange.setDiscountPercentage(dto.getDiscountPercentage());
        discountToChange.setExpireDate(dto.getExpireDate());
        return DiscountDTO.fromDiscount(discount.get());
    }

    @Override
    public List<DiscountDTO> getDiscounts() {
        return repository.findAll().stream().map(DiscountDTO::fromDiscount).collect(Collectors.toList());
    }

    @Override
    public DiscountDTO getDiscount(String name) {
        return DiscountDTO.fromDiscount(repository.findDiscountByDiscountName(name).get());
    }
}
