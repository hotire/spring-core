package com.github.hotire.springcore.controller;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractBaseController  {
  protected final ObjectMapper objectMapper;
  protected final RestTemplate restTemplate;
  public AbstractBaseController(ObjectMapper objectMapper, RestTemplate restTemplate) {
    this.objectMapper = objectMapper;
    this.restTemplate = restTemplate;
  }
}
