package com.kakao.hotire.springcore.register;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleBean2 {
  public SimpleBean2() {
    log.info("SimpleBean2 hashCode : {}", this.hashCode());
  }
}
