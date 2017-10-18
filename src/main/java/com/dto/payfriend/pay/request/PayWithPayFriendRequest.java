package com.dto.payfriend.pay.request;

import com.dto.payfriend.pay.PayFriend;

public class PayWithPayFriendRequest {

    private PayFriend payFriend;
    private PayFriend targetFriend;
    private Payment payment;

    public PayFriend getPayFriend() {
        return payFriend;
    }

    public PayFriend getTargetFriend() {
        return targetFriend;
    }

    public Payment getPayment() {
        return payment;
    }
}
