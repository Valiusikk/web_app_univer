package com.example.demo.service;

import com.example.demo.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {
    DiscountDTO createDiscount(DiscountDTO discount);
    DiscountDTO deleteDiscount(String discountCode);
    DiscountDTO updateDiscount(String name,DiscountDTO discount);
    List<DiscountDTO> getDiscounts();
    DiscountDTO getDiscount(String name);
}
