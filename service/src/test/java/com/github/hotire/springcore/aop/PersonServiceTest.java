package com.github.hotire.springcore.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class PersonServiceTest {

  @Test
  void hello() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(PersonService.class);
    enhancer.setCallback((FixedValue) () -> "Hello Tom!");
    PersonService proxy = (PersonService) enhancer.create();

    String res = proxy.sayHello(null);

    assertEquals("Hello Tom!", res);
  }

  @Disabled("migration Junit5")
  @Test
  void hello_cannot_subclass_final_class() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(FinalPersonService.class);
    enhancer.setCallback((FixedValue) () -> "Hello Tom!");

    PersonService proxy = (PersonService) enhancer.create();
    String res = proxy.sayHello(null);

    assertEquals("Hello Tom!", res);
  }
}