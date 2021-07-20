package com.github.hotire.springcore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.hotire.springcore.bean.Proto;
import com.github.hotire.springcore.log.Monitor;

@Monitor
@RestController
public class SimpleRestController {

  @Autowired(required = false)
  private Proto proto;

  @GetMapping("/hello3")
  public String hello() {
    return "hello3";
  }

  @GetMapping("/hello4")
  public String h() {
    return proto.toString();
  }

}
