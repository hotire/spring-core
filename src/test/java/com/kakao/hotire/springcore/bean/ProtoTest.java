package com.kakao.hotire.springcore.bean;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProtoTest {
    @Configuration
    static class Config {
        @Bean
        public Single single() {
      return new Single();
    }

        @Scope("prototype")
        @Bean
        public Proto proto() {
      return new Proto();
    }
    }

    @Autowired
    private ApplicationContext context;

    @Test
    void assert_singleton() {
        // when
        final Single single = context.getBean(Single.class);
        // then
        assertThat(single).isEqualTo(single);
    }

    @Test
    void assert_prototype() {
        // when
        final Proto proto = context.getBean(Proto.class);
        // then
        assertThat(proto).isNotEqualTo(context.getBean(Proto.class));
    }
}