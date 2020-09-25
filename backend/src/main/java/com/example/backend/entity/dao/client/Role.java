package com.example.backend.entity.dao.client;

import com.example.backend.entity.dao.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

/*
    @author Kacper Buczak 
*/
@Entity
@Table(name = "role")
public class Role extends BaseEntity implements GrantedAuthority {

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<Client> clients;

    @ManyToMany
    @JoinTable(
            name = "roles_privileges",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addClient(Client client) {
        this.clients.add(client);
    }

    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients.addAll(clients);
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
