package com.example.backend.entity.dto.product;

import com.example.backend.entity.dto.BaseDto;
import com.example.backend.entity.dto.client.BasketDto;
import com.example.backend.entity.dto.client.PaymentShortDto;

import java.util.Date;

/*
    @author Karol Gromacki 
*/
public class OrderDto extends BaseDto {

    private Date date;

    private BasketDto basket;

    private PaymentShortDto payment;

    public OrderDto() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BasketDto getBasket() {
        return basket;
    }

    public void setBasket(BasketDto basket) {
        this.basket = basket;
    }

    public PaymentShortDto getPayment() {
        return payment;
    }

    public void setPayment(PaymentShortDto payment) {
        this.payment = payment;
    }
}
