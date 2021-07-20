package com.github.hotire.springcore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CorsController.class)
class CorsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void cors() throws Exception {
    mockMvc.perform(get("/cors"))
           .andExpect(header().exists(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN))
           .andExpect(header().exists(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS))
           .andDo(print());
  }
}