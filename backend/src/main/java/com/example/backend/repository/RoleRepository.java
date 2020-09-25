package com.example.backend.repository;

import com.example.backend.entity.dao.client.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
    @author Kacper Buczak 
*/
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("Select r From Role r where r.id=2")
    List<Role> getDefaultRoles();
}
