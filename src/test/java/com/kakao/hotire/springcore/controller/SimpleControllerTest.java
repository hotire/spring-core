package com.kakao.hotire.springcore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.kakao.hotire.springcore.config.RoutingConfig;

@WebMvcTest(RoutingConfig.class)
class SimpleControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void whenSimpleUrlMapping_thenMappedOK() throws Exception {
    mockMvc.perform(get("/simple"))
           .andExpect(status().isOk())
           .andExpect(view().name("/index"));
  }
}