package com.kakao.hotire.springcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * RequestMappingHandlerMapping / RequestMappingHandlerAdapter
 */
@Controller
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return "index";
  }

}
