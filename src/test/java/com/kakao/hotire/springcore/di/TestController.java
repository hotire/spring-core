package com.kakao.hotire.springcore.di;

import lombok.Getter;

public class TestController {
  @Inject @Getter
  private TestService testService;
}
