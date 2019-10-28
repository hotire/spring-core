package com.kakao.hotire.springcore.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
  private PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }
  @GetMapping("/person")
  public String hello() {
    return personService.sayHello("hi");
  }
}
