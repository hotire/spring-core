package com.github.hotire.springcore.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import com.github.hotire.springcore.controller.SimpleController;

@Configuration
public class RoutingConfig {

    @Bean
    public SimpleUrlHandlerMapping sampleServletMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        mapping.setOrder(0);
        Properties urlProperties = new Properties();
        urlProperties.put("/simple", new SimpleController());
        mapping.setMappings(urlProperties);
        return mapping;
    }
}
