package com.dto.cc.response;

public class Customer {
    private String address;
    private int[] dateOfBirth;
    private String emailAddress;
    private String firstName;
    private String lastName;

    public String getAddress() {
        return address;
    }

    public int[] getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
