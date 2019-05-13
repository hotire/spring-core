package com.kakao.hotire.springcore.register;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationAndComponentTest {

  @Autowired
  SimpleBean2 simpleBean2;

  @Autowired
  ConfigurationAndComponent.Config config;

  @Test
  public void di() {
    log.info("Test simpleBean2 hashCode : {}",  simpleBean2.hashCode());
  }

}