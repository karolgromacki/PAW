package com.example.backend.repository;

import com.example.backend.entity.dao.client.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
    @author Karol Gromacki 
*/
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("Select p from Payment p where p.client.id =:clientId")
    List<Payment> findAllByClientId(@Param("clientId") Long clientId);

    @Query("select p from Payment p where p.order.id =:orderId")
    Payment findOneByOrderId(@Param("orderId") Long orderId);
}
