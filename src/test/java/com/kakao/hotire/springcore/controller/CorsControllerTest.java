package com.kakao.hotire.springcore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CorsController.class)
public class CorsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void cors() throws Exception {
    mockMvc
      .perform(get("/cors"))
      .andExpect(header().exists(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN))
      .andExpect(header().exists(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS))
      .andDo(print());
  }
}