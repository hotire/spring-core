package com.kakao.hotire.springcore.importSelector;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableRestTemplate
public class EnableRestTemplateTest {

  @Autowired
  ApplicationContext context;

  @Test
  public void di() {
    assertThat(context.getBean(RestTemplate.class)).isNotNull();
  }
}