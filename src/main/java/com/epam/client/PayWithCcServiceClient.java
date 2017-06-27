package com.epam.client;

import com.epam.dto.cc.request.PayWithCcRequest;
import com.epam.dto.cc.response.PayWithCcResponse;
import org.springframework.web.client.RestTemplate;

public class PayWithCcServiceClient {
    private RestTemplate restTemplate;

    public PayWithCcServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PayWithCcResponse pay(PayWithCcRequest payWithCcRequest) {
        // @formatter:off
        return restTemplate
                .postForEntity("http://192.168.99.100:8085/pay", payWithCcRequest, PayWithCcResponse.class)
                .getBody();
        // @formatter:on
    }
}
