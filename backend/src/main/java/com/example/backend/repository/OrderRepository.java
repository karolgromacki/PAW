package com.example.backend.repository;

import com.example.backend.entity.dao.product.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    @author Kacper Buczak 
*/
public interface OrderRepository extends JpaRepository<Order, Long> {
}
