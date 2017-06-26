package com.epam.controller;

import com.epam.dto.cc.request.PayWithCcRequest;
import com.epam.dto.cc.response.PayWithCcResponse;
import com.epam.dto.payfriend.getuser.request.GetUserRequest;
import com.epam.dto.payfriend.getuser.response.GetUserResponse;
import com.epam.dto.payfriend.pay.request.PayWithPayFriendRequest;
import com.epam.dto.payfriend.pay.response.PayWithPayFriendResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PaymentController {

    private final RestTemplate restTemplate;

    public PaymentController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/payWithPayFriend", method = POST)
    public PayWithPayFriendResponse payWithPayFriend(@RequestBody PayWithPayFriendRequest payWithPayFriendRequest)
            throws JsonProcessingException {
        GetUserRequest payFriendIdRequest = new GetUserRequest(payWithPayFriendRequest.getPayFriend().getEmail());
        GetUserResponse payFriendGetUserResponse = restTemplate
                .postForEntity("http://192.168.99.100:8087/getUser", payFriendIdRequest, GetUserResponse.class)
                .getBody();

        GetUserRequest targetPayFriendIdRequest = new GetUserRequest(
                payWithPayFriendRequest.getTargetFriend().getEmail());
        GetUserResponse targetPayFriendGetUserResponse = restTemplate
                .postForEntity("http://192.168.99.100:8087/getUser", targetPayFriendIdRequest, GetUserResponse.class)
                .getBody();

        payWithPayFriendRequest.getPayFriend().setUserId(payFriendGetUserResponse.getUserId());
        payWithPayFriendRequest.getTargetFriend().setUserId(targetPayFriendGetUserResponse.getUserId());

        return restTemplate.postForEntity("http://192.168.99.100:8087/pay", payWithPayFriendRequest,
                PayWithPayFriendResponse.class).getBody();
    }

    @RequestMapping(value = "/payWithCC", method = POST)
    public PayWithCcResponse payWithCc(@RequestBody PayWithCcRequest payWithCcRequest) throws JsonProcessingException {
        return restTemplate.postForEntity("http://192.168.99.100:8085/pay", payWithCcRequest, PayWithCcResponse.class)
                .getBody();
    }
}
