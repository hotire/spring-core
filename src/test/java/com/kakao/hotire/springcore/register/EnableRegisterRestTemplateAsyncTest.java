package com.kakao.hotire.springcore.register;

import static org.assertj.core.api.Assertions.assertThat;

import com.kakao.hotire.springcore.importSelector.Mode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.AsyncRestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableRegisterRestTemplate(mode = Mode.ASYNC)
public class EnableRegisterRestTemplateAsyncTest {
  @Autowired
  ApplicationContext context;

  @SuppressWarnings("deprecation")
  @Test
  public void di() {
    assertThat(context.getBean(AsyncRestTemplate.class)).isNotNull();
  }
}
