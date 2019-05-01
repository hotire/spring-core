package com.kakao.hotire.springcore.aop;

import static org.junit.Assert.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;

@Slf4j
public class PersonServiceTest {

  @Test
  public void hello() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(PersonService.class);
    enhancer.setCallback((FixedValue) () -> "Hello Tom!");
    PersonService proxy = (PersonService) enhancer.create();

    String res = proxy.sayHello(null);

    assertEquals("Hello Tom!", res);
  }

  @Test(expected = IllegalArgumentException.class)
  public void hello_cannot_subclass_final_class() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(FinalPersonService.class);
    enhancer.setCallback((FixedValue) () -> "Hello Tom!");

    PersonService proxy = (PersonService) enhancer.create();
    String res = proxy.sayHello(null);

    assertEquals("Hello Tom!", res);
  }
}