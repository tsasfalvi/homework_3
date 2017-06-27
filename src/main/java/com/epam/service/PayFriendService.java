package com.epam.service;

import com.epam.client.PayFriendServiceClient;
import com.epam.dto.payfriend.pay.request.PayWithPayFriendRequest;
import com.epam.dto.payfriend.pay.response.PayWithPayFriendResponse;
import org.springframework.stereotype.Service;

@Service
public class PayFriendService {
    private PayFriendServiceClient payFriendServiceClient;

    public PayFriendService(PayFriendServiceClient payFriendServiceClient) {
        this.payFriendServiceClient = payFriendServiceClient;
    }

    public PayWithPayFriendResponse pay(PayWithPayFriendRequest payWithPayFriendRequest) {
        String userId = payFriendServiceClient.getUserId(payWithPayFriendRequest.getPayFriend().getEmail());
        String targetFriendUserId = payFriendServiceClient.getUserId(payWithPayFriendRequest.getTargetFriend().getEmail());

        // TODO transformation might be better, then setting properties
        payWithPayFriendRequest.getPayFriend().setUserId(userId);
        payWithPayFriendRequest.getTargetFriend().setUserId(targetFriendUserId);

        return payFriendServiceClient.pay(payWithPayFriendRequest);
    }
}
