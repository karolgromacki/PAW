package com.example.backend.repository;

import com.example.backend.entity.dao.product.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
    @author Kacper Buczak 
*/
public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query("select o from Order o where o.basket.id =:basketId")
    List<Order> getAllOrderByBasketId(@Param("basketId") Long basketId);
}
