package com.kakao.hotire.springcore.aop;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {
  private final PersonService personService;

  @GetMapping("/person")
  public String hello() {
    return personService.sayHello("hi");
  }
}
