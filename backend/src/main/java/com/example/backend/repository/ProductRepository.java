package com.example.backend.repository;

import com.example.backend.entity.dao.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    @author Karol Gromacki 
*/
public interface ProductRepository extends JpaRepository<Product, Long> {
}
