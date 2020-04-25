package com.kakao.hotire.springcore.config;

import com.kakao.hotire.springcore.controller.SimpleController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

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
