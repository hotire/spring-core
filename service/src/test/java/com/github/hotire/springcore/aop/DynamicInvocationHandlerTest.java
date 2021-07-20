package com.github.hotire.springcore.aop;

import java.lang.reflect.Proxy;

import org.junit.jupiter.api.Test;

class DynamicInvocationHandlerTest {

  @Test
  void proxy() {
    PersonService2 personService2 = new PersonService2();
    AOPService proxyInstance = (AOPService) Proxy.newProxyInstance(PersonService2.class.getClassLoader(),
                                                                   new Class[] { AOPService.class }, new DynamicInvocationHandler(personService2));

    System.out.println("created proxy");

    proxyInstance.service(); // hello AOPService
  }
}