package com.github.hotire.springcore.aop;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonService2 implements AOPService {

  @Override
  public void service() {
    log.info("hello AOPService");
  }
}
