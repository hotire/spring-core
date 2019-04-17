package com.kakao.hotire.springcore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

  @GetMapping("/hello3")
  public String hello() {
    return "hello3";
  }

}
