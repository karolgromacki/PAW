package com.example.backend.repository;

import com.example.backend.entity.dao.client.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    @author Kacper Buczak 
*/
public interface BasketRepository extends JpaRepository<Basket,Long> {
}
