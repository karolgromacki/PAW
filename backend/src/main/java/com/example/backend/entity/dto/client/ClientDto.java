package com.example.backend.entity.dto.client;

import com.example.backend.entity.dto.BaseDto;

import java.util.List;

/*
    @author Kacper Buczak 
*/
public class ClientDto extends BaseDto {
    private String firstName;
    private String lastName;
    private String email;
    private String Address;
    private String phoneNumber;
    private String NIP;
    private List<BasketDto> baskets;
    private List<PaymentShortDto> payments;

    public ClientDto() {
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

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public List<BasketDto> getBaskets() {
        return baskets;
    }

    public void setBaskets(List<BasketDto> baskets) {
        this.baskets = baskets;
    }

    public List<PaymentShortDto> getPayments() {
        return payments;
    }

    public void setPayments(List<PaymentShortDto> payments) {
        this.payments = payments;
    }
}
