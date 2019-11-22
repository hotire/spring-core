package com.kakao.hotire.springcore.di;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

public class TestController {
  @Autowired
  @Getter
  private TestService testService;
}
