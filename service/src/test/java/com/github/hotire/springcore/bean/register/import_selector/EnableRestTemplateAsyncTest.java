package com.github.hotire.springcore.bean.register.import_selector;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.AsyncRestTemplate;

@SpringBootTest
@EnableRestTemplate(mode = Mode.ASYNC)
class EnableRestTemplateAsyncTest {

  @Autowired
  ApplicationContext context;

  @Test
  void di() {
    assertThat(context.getBean(AsyncRestTemplate.class)).isNotNull();
  }
}
