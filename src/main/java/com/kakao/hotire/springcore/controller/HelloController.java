package com.kakao.hotire.springcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * RequestMappingHandlerMapping / RequestMappingHandlerAdapter
 */
@Controller
public class HelloController {

  @GetMapping("/hello")
  public ModelAndView hello() {
    return new ModelAndView("/index");
  }

  @GetMapping("/hello2")
  public @ResponseBody String hello2() {
    return "hello2";
  }
}
