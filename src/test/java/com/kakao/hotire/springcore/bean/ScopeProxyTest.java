package com.kakao.hotire.springcore.bean;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScopeProxyTest {

  @Configuration
  static class Config {
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.INTERFACES)
    @Bean
    public Proto proto() {
      return new Proto();
    }
  }

  @Autowired
  private ApplicationContext context;

  @Test
  public void assert_prototype() {
    Proto proto = context.getBean(Proto.class);
    assertThat(proto).isEqualTo(context.getBean(Proto.class));
  }
}
