package com.github.hotire.springcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.hotire.springcore.service.HelloService;

/**
 * RequestMappingHandlerMapping / RequestMappingHandlerAdapter
 */
@Controller
public class HelloController implements ApplicationListener {

  private HelloService helloService;
  
  @Bean(initMethod = "init")
  public com.github.hotire.springcore.controller.InitTest initTest() {
    return new InitTest();
  }

  public HelloController(HelloService helloService) {
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

  @Override
  public void onApplicationEvent(ApplicationEvent event) {

  }
}
