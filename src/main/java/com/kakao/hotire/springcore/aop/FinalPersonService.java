package com.kakao.hotire.springcore.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public final class FinalPersonService {
  public String sayHello(String name) {
    return "Hello " + name;
  }
}
