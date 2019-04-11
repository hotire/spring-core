package com.kakao.hotire.springcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * RequestMappingHandlerMapping / RequestMappingHandlerAdapter
 */
@RestController
public class HelloController {

  @GetMapping("/hello")
  public ModelAndView hello() {
    return new ModelAndView("/index");
  }
}
