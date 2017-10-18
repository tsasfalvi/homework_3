package com.dto.cc.response;

public class PayWithCcResponse {
    private double amount;
    private int[] paymentTime;
    private Customer customer;

    public double getAmount() {
        return amount;
    }

    public int[] getPaymentTime() {
        return paymentTime;
    }

    public Customer getCustomer() {
        return customer;
    }
}
