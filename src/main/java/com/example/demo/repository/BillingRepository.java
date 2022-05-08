package com.example.demo.repository;

import com.example.demo.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("billingRepository")
public interface BillingRepository extends JpaRepository<Billing, UUID> {
}
