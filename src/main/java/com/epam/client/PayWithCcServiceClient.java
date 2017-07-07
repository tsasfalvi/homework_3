package com.epam.client;

import com.epam.dto.cc.request.PayWithCcRequest;
import com.epam.dto.cc.response.PayWithCcResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PayWithCcServiceClient {

    @Value("${payWithCc.host}")
    private String host;

    private RestTemplate restTemplate;

    public PayWithCcServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PayWithCcResponse pay(PayWithCcRequest payWithCcRequest) {
        // @formatter:off
        return restTemplate
                // TODO use uriBuilder instead
                .postForEntity(host + "/pay", payWithCcRequest, PayWithCcResponse.class)
                .getBody();
        // @formatter:on
    }
}
