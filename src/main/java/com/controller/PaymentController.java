package com.controller;

import com.dto.cc.request.PayWithCcRequest;
import com.dto.cc.response.PayWithCcResponse;
import com.dto.payfriend.pay.request.PayWithPayFriendRequest;
import com.dto.payfriend.pay.response.PayWithPayFriendResponse;
import com.service.PayFriendService;
import com.service.PayWithCcService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class PaymentController {
    private PayFriendService payFriendService;
    private PayWithCcService payWithCcService;

    public PaymentController(PayFriendService payFriendService, PayWithCcService payWithCcService) {
        this.payFriendService = payFriendService;
        this.payWithCcService = payWithCcService;
    }

    @RequestMapping(value = "/payWithPayFriend", method = POST)
    public PayWithPayFriendResponse payWithPayFriend(@RequestBody PayWithPayFriendRequest payWithPayFriendRequest)
            throws JsonProcessingException {
        return payFriendService.pay(payWithPayFriendRequest);
    }

    @RequestMapping(value = "/payWithCc", method = POST)
    public PayWithCcResponse payWithCc(@RequestBody PayWithCcRequest payWithCcRequest) throws JsonProcessingException {
        return payWithCcService.payWithCc(payWithCcRequest);
    }
}
