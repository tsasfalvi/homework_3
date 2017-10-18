package com.dto.cc.request;

public class CreditCard {
    private String creditCardNumber;
    private int cvc;
    private ExpirationDate expirationDate;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public int getCvc() {
        return cvc;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }
}
