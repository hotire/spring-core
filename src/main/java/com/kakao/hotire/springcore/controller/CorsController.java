package com.kakao.hotire.springcore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/cors")
@RestController
public class CorsController {

  @CrossOrigin("*")
  @GetMapping
  public ResponseEntity hello () {
    return ResponseEntity.ok().body("hello");
  }
}
