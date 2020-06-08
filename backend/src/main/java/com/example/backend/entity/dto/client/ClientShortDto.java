package com.example.backend.entity.dto.client;

import com.example.backend.entity.dto.BaseDto;

/*
    @author Kacper Buczak 
*/
public class ClientShortDto extends BaseDto {
    private String firstName;
    private String lastName;
    private String email;
    private String Address;

    public ClientShortDto() {
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
}
