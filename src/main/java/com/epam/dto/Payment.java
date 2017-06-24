package com.epam.dto;

public class Payment {

    private Customer payer;
    private Customer payee;
    private double amount;

    public double getAmount() {
        return amount;
    }
}
