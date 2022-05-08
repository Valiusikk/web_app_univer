package com.example.demo.service.implementation;

import com.example.demo.dto.BillingDTO;
import com.example.demo.entity.Billing;
import com.example.demo.repository.BillingRepository;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService{

    private final BillingRepository repository;

    private final BookingRepository bookingRepository;

    @Override
    public BillingDTO createBilling(BillingDTO billingDTO) {
        final Billing billing = create(billingDTO);
        repository.save(billing);
        return BillingDTO.fromBilling(billing);
    }

    private Billing create(BillingDTO billingDto){
        final Billing billing = new Billing();
        billing.setBillId(UUID.randomUUID());
        billing.setBillDate(billingDto.getBillDate());
        billing.setBillStatus(billingDto.getBillStatus());
        billing.setTaxAmount(billingDto.getTaxAmount());
        billing.setTotalAmount(billingDto.getTotalAmount());
        billing.setDiscountAmount(billing.getDiscountAmount());
        return billing;
    }

    @Override
    public BillingDTO updateBilling(float amount,BillingDTO billing) {
        return null;
    }

    @Override
    public BillingDTO deleteBilling(float amount) {
        return null;
    }

    @Override
    public BillingDTO getBilling(float amount) {
        return null;
    }

    @Override
    public List<BillingDTO> getBillings(String clientEmail) {
        return null;
    }

    @Override
    public List<BillingDTO> getBillings() {
        return null;
    }
}
