package com.example.backend.repository;

import com.example.backend.entity.dao.client.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
    @author Kacper Buczak 
*/
public interface BasketRepository extends JpaRepository<Basket, Long> {

    @Query("Select b from Basket b where b.client.id=:clientId")
    List<Basket> getBasketsByUser(@Param("clientId") Long clientId);
}
