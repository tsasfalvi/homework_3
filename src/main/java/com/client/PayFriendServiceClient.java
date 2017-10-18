package com.client;

import com.dto.payfriend.getuser.response.GetUserResponse;
import com.dto.payfriend.pay.request.PayWithPayFriendRequest;
import com.dto.payfriend.pay.response.PayWithPayFriendResponse;
import com.dto.payfriend.getuser.request.GetUserRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PayFriendServiceClient {
    private RestTemplate restTemplate;

    public PayFriendServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getUserId(String email) {
        GetUserRequest payFriendIdRequest = new GetUserRequest(email);

        // @formatter:off
        GetUserResponse payFriendGetUserResponse = restTemplate
                .postForEntity("http://192.168.99.100:8087/getUser", payFriendIdRequest, GetUserResponse.class)
                .getBody();
        // @formatter:on

        return payFriendGetUserResponse.getUserId();
    }

    public PayWithPayFriendResponse pay(PayWithPayFriendRequest payWithPayFriendRequest) {
        // @formatter:off
        return restTemplate
                .postForEntity("http://192.168.99.100:8087/pay", payWithPayFriendRequest,
                PayWithPayFriendResponse.class)
                .getBody();
        // @formatter:on
    }
}
