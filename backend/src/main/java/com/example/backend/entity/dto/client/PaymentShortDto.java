package com.example.backend.entity.dto.client;

import com.example.backend.entity.dao.enums.PaymentType;
import com.example.backend.entity.dto.BaseDto;

import java.util.Date;

/*
    @author Karol Gromacki 
*/
public class PaymentShortDto extends BaseDto {

    private Long amount;

    private PaymentType paymentType;

    private Date date;

    public PaymentShortDto() {
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
}
