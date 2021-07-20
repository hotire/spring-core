package com.github.hotire.springcore.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
  private com.github.hotire.springcore.aop.PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }
  @GetMapping("/person")
  public String hello() {
    return personService.sayHello("hi");
  }
}
