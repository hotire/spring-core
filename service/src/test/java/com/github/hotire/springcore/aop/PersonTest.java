package com.github.hotire.springcore.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class PersonTest {

  @Autowired
  PersonService personService;

  @Test
  void assert_aop() {
    log.debug("stop");
    personService.sayHello("hi");
  }
}
