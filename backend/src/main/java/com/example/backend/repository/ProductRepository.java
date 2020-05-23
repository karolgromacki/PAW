package com.example.backend.repository;

import com.example.backend.entity.dao.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    @author Kacper Buczak 
*/
public interface ProductRepository extends JpaRepository<Product, Long> {
}
