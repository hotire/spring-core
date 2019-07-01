package com.kakao.hotire.springcore.register;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleBean {
  public SimpleBean() {
    log.info("SimpleBean hashCode : {}", this.hashCode());
  }
}
