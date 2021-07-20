package com.github.hotire.springcore.aop;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
  public String sayHello(String name) {
    return "Hello " + name;
  }
}
