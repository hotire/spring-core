package com.kakao.hotire.springcore.http;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

public class Utf8RestTemplateCustomizer implements RestTemplateCustomizer {
    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.getMessageConverters()
                    .stream()
                    .filter(writer -> writer instanceof AbstractHttpMessageConverter)
                    .map(AbstractHttpMessageConverter.class::cast)
                    .forEach(writer -> writer.setDefaultCharset(StandardCharsets.UTF_8));
    }
}
