package com.kakao.hotire.springcore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class BaseController extends AbstractBaseController implements InitializingBean {

  public BaseController(RestTemplate restTemplate, ObjectMapper objectMapper) {
    super(objectMapper, restTemplate);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("BaseController");
    System.out.println(objectMapper);
    System.out.println(restTemplate);
  }
}
