package com.example.backend.entity.dao.product;

import com.example.backend.entity.dao.BaseEntity;
import com.example.backend.entity.dao.client.Basket;
import com.example.backend.entity.dao.client.Payment;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

/*
    @author Kacper Buczak 
*/
@Entity
@Table(name = "order")
public class Order extends BaseEntity {

    private Date date;

    @OneToOne
    private Basket basket;

    @OneToOne
    private Payment payment;

    public Order() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
