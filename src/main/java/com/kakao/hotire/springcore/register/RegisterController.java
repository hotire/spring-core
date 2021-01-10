package com.kakao.hotire.springcore.register;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

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
