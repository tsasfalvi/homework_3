package com.dto.cc.request;

public class PayWithCcRequest {
    private CreditCard creditCard;
    private Customer customer;
    private Payment payment;

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Payment getPayment() {
        return payment;
    }
}
