package com.example.demo.dto;

import com.example.demo.entity.Discount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDTO {

    private String discountName;

    private LocalDate expireDate;

    private float discountPercentage;

    public static DiscountDTO fromDiscount(Discount discount) {
        return new DiscountDTO(
                discount.getDiscountName(),
                discount.getExpireDate(),
                discount.getDiscountPercentage()
        );
    }
}
