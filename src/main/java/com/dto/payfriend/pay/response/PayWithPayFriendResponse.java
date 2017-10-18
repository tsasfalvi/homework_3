package com.dto.payfriend.pay.response;

import com.dto.payfriend.pay.PayFriend;

public class PayWithPayFriendResponse {
    private double amount;
    private int[] paymentTime;
    private PayFriend payFriend;
    private PayFriend targetFriend;

    public double getAmount() {
        return amount;
    }

    public PayFriend getPayFriend() {
        return payFriend;
    }

    public PayFriend getTargetFriend() {
        return targetFriend;
    }

    public int[] getPaymentTime() {
        return paymentTime;
    }
}
