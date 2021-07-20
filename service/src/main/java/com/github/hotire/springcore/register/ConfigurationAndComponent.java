package com.github.hotire.springcore.register;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import lombok.extern.slf4j.Slf4j;

/**
 * http://dimafeng.com/2015/08/29/spring-configuration_vs_component/
 */
@Slf4j
public class ConfigurationAndComponent {

  @Configuration
  public static class Config {

    @Bean
    public com.github.hotire.springcore.register.SimpleBean simpleBean() {
      return new SimpleBean();
    }

    @Bean
    public com.github.hotire.springcore.register.SimpleBeanConsumer simpleBeanConsumer() {
      Assert.isTrue(simpleBean() == simpleBean(), "Configuration Bean");
      return new SimpleBeanConsumer(simpleBean());
    }
  }

  @Component
  public static class ComponentConfig {

    @Bean
    public com.github.hotire.springcore.register.SimpleBean2 simpleBean2() {
      return new SimpleBean2();
    }

    @Bean
    public com.github.hotire.springcore.register.SimpleBeanConsumer2 simpleBeanConsumer2() {
      Assert.isTrue(simpleBean2() != simpleBean2(), "Component Bean");
      return new SimpleBeanConsumer2(simpleBean2());
    }
  }
}
