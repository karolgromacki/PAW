package com.example.backend.entity.dao.client;

import com.example.backend.entity.dao.BaseEntity;
import com.example.backend.entity.dao.enums.PaymentType;
import com.example.backend.entity.dao.product.Order;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

/*
    @author Kacper Buczak 
*/
@Entity
@Table(name = "payment")
public class Payment extends BaseEntity {

    @Min(value = 0)
    private Long amount;

    @Enumerated
    private PaymentType paymentType;

    private Date date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Client client;

    @OneToOne(mappedBy = "payment")
    private Order order;

    public Payment() {
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
