package com.kakao.hotire.springcore.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ScopeProxyTest {

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
    void assert_prototype() {
        // when
        final Proto proto = context.getBean(Proto.class);
        // then
        assertThat(proto).isEqualTo(context.getBean(Proto.class));
    }

}
