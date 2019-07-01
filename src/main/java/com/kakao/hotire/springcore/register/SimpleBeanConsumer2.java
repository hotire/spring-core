package com.kakao.hotire.springcore.register;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class SimpleBeanConsumer2 {
  private SimpleBean2 simpleBean2;
  public SimpleBeanConsumer2(SimpleBean2 simpleBean2) {
    this.simpleBean2 = simpleBean2;
    log.info("SimpleBeanConsumer2 SimpleBean2 hashcode : {}", this.simpleBean2.hashCode());
  }
}
