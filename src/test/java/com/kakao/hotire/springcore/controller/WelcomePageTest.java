package com.kakao.hotire.springcore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class WelcomePageTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void whenSimpleUrlMapping_thenMappedOK() throws Exception {
    mockMvc.perform(get("/"))
           .andExpect(status().isOk())
           .andExpect(view().name("index"));
  }
}
