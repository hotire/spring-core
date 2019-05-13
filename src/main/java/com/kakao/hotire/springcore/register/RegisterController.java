package com.kakao.hotire.springcore.register;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegisterController {
  private final ConfigurationAndComponent.Config config;

  @GetMapping("/config")
  public String config() {
    config.simpleBean();
    return "config";
  }
}
