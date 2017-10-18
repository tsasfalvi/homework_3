package com.registry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Basic {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
