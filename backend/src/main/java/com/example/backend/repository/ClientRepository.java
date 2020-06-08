package com.example.backend.repository;

import com.example.backend.entity.dao.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/*
    @author Kacper Buczak 
*/
public interface ClientRepository extends JpaRepository<Client, Long> {
}
