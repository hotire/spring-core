package com.kakao.hotire.springcore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractBaseController  {
  protected final ObjectMapper objectMapper;
  protected final RestTemplate restTemplate;
  public AbstractBaseController(ObjectMapper objectMapper, RestTemplate restTemplate) {
    this.objectMapper = objectMapper;
    this.restTemplate = restTemplate;
  }
}
