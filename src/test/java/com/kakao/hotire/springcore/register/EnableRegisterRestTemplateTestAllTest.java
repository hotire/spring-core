package com.kakao.hotire.springcore.register;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import com.kakao.hotire.springcore.importSelector.Mode;

@SpringBootTest
@EnableRegisterRestTemplate(mode = Mode.ALL)
class EnableRegisterRestTemplateTestAllTest {

  @Autowired
  ApplicationContext context;

  @Test
  void di() {
    assertThat(context.getBean(AsyncRestTemplate.class)).isNotNull();
    assertThat(context.getBean(RestTemplate.class)).isNotNull();
  }
}
