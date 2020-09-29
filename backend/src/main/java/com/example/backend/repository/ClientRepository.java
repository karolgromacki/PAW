package com.example.backend.repository;

import com.example.backend.entity.dao.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/*
    @author Karol Gromacki 
*/
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c where c.login=:login")
    public Client findByEmail(@Param("login") String login);
}
