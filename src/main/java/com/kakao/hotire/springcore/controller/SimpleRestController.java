package com.kakao.hotire.springcore.controller;

import com.kakao.hotire.springcore.bean.Proto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
