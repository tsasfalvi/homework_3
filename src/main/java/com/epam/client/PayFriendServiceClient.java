package com.epam.client;

import com.epam.dto.payfriend.getuser.request.GetUserRequest;
import com.epam.dto.payfriend.getuser.response.GetUserResponse;
import com.epam.dto.payfriend.pay.request.PayWithPayFriendRequest;
import com.epam.dto.payfriend.pay.response.PayWithPayFriendResponse;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.Cacheable;

import java.util.concurrent.TimeUnit;

@Component
public class PayFriendServiceClient {
    private RestTemplate restTemplate;
    private HazelcastInstance hazelcastInstance;

    public PayFriendServiceClient(RestTemplate restTemplate, HazelcastInstance hazelcastInstance) {
        this.restTemplate = restTemplate;
        this.hazelcastInstance = hazelcastInstance;
    }

    @Cacheable("userId")
    public String getUserId(String email) {
        long start = System.currentTimeMillis();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        GetUserRequest payFriendIdRequest = new GetUserRequest(email);

        // @formatter:off
        GetUserResponse payFriendGetUserResponse = restTemplate
                .postForEntity("http://192.168.99.100:8087/getUser", payFriendIdRequest, GetUserResponse.class)
                .getBody();
        // @formatter:on

        System.out.println("millis required to get userId is: " + (System.currentTimeMillis() - start));

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
