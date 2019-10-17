package com.kakao.hotire.springcore.controller;

import com.kakao.hotire.springcore.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * RequestMappingHandlerMapping / RequestMappingHandlerAdapter
 */
@Controller
public class HelloController {

  private HelloService helloService;

  public HelloController() {
    System.out.println();
  }

  @PostMapping("/hello")
  public ModelAndView hello() {
    return new ModelAndView("/index");
  }

  @GetMapping("/hello2")
  public @ResponseBody String hello2() {
    return "hello2";
  }

  @Autowired
  public void setHelloService(HelloService helloService) {
    this.helloService = helloService;
  }

}
