package com.example.backend.entity.dto.client;

import com.example.backend.entity.dao.client.Basket;
import com.example.backend.entity.dao.client.Payment;
import com.example.backend.entity.dto.BaseDto;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
}
