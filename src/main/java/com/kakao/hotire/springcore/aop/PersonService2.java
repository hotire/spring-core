package com.kakao.hotire.springcore.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonService2 implements AOPService {

  @Override
  public void service() {
    log.info("hello AOPService");
  }
}
