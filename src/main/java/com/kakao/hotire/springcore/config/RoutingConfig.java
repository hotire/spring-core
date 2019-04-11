package com.kakao.hotire.springcore.config;

import com.kakao.hotire.springcore.controller.SimpleController;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

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
