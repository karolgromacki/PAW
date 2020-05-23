package com.example.backend.repository;

import com.example.backend.entity.dao.client.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    @author Kacper Buczak 
*/
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
