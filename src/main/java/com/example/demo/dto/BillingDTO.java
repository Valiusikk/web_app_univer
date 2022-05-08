package com.example.demo.dto;

import com.example.demo.entity.Billing;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingDTO {

    private LocalDate billDate;

    private String billStatus;

    private float discountAmount;

    private float totalAmount;

    private float taxAmount;

    public static BillingDTO fromBilling(Billing billing) {
        return new BillingDTO(
                billing.getBillDate(),
                billing.getBillStatus(),
                billing.getDiscountAmount(),
                billing.getTotalAmount(),
                billing.getTaxAmount()
        );
    }
}
