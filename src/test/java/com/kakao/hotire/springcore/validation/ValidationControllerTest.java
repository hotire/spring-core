package com.kakao.hotire.springcore.validation;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class ValidationControllerTest {

    @Test
    void post() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        final String json = objectMapper.writeValueAsString(new ValidationRequest());
        new RestTemplate()
                .postForObject("http://localhost:8080/v1/validation", json, String.class);

    }
}