package com.example.backend.entity.dao.client;


import com.example.backend.entity.dao.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

/*
    @author Karol Gromacki 
*/
@Entity
@Table(name = "clients")
public class Client extends BaseEntity {

    @NotBlank
    @Size(min = 0, max = 30)
    private String firstName;
    @NotBlank
    @Size(min = 0, max = 30)
    private String lastName;
    @NotBlank
    @Size(min = 0, max = 50)
    private String email;
    @NotBlank
    @Size(min = 0, max = 100)
    private String Address;
    @NotBlank
    @Size(min = 0, max = 15)
    private String phoneNumber;
    @NotBlank
    @Size(min = 0, max = 32)
    private String login;
    @NotBlank
    @Size(min = 0, max = 128)
    private String password;
    @NotBlank
    @Size(min = 0, max = 32)
    private String NIP;
    private Long accountBalance;


    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "client")
    private List<Basket> baskets;
    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "client")
    private List<Payment> payments;



    @NotNull
    private boolean blocked;

    private boolean enabled;

    private boolean tokenExpired;
    @ManyToMany
    @JoinTable(
            name = "clients_roles",
            joinColumns = @JoinColumn(
                    name = "clients_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public Client() {
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<Basket> baskets) {
        this.baskets = baskets;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
