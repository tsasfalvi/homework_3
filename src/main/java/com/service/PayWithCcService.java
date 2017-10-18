package com.service;

import com.client.PayWithCcServiceClient;
import com.dto.cc.request.PayWithCcRequest;
import com.dto.cc.response.PayWithCcResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public class PayWithCcService {
    private PayWithCcServiceClient payWithCcServiceClient;

    public PayWithCcService(PayWithCcServiceClient payWithCcServiceClient) {
        this.payWithCcServiceClient = payWithCcServiceClient;
    }

    public PayWithCcResponse payWithCc(PayWithCcRequest payWithCcRequest) throws JsonProcessingException {
        return payWithCcServiceClient.pay(payWithCcRequest);
    }
}
