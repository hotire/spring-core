package com.kakao.hotire.springcore.aop;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public final class FinalPersonService {
  public String sayHello(String name) {
    return "Hello " + name;
  }
}
