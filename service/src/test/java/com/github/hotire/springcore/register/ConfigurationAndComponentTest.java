package com.github.hotire.springcore.register;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class ConfigurationAndComponentTest {

  @Autowired
  SimpleBean2 simpleBean2;

  @Autowired
  ConfigurationAndComponent.Config config;

  @Test
  void di() {
    log.info("Test simpleBean2 hashCode : {}", simpleBean2.hashCode());
  }

}