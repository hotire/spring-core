package com.kakao.hotire.springcore.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SampleController {

  @GetMapping("/sample/{name}")
  public String sample(@PathVariable("name") Person person) {
    log.debug(person.toString());
    return "hello " + person.getName();
  }
}
