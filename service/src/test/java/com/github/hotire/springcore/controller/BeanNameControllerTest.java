package com.github.hotire.springcore.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BeanNameController.class)
class BeanNameControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void assert_get() throws Exception {
    mockMvc.perform(get("/bean"))
           .andExpect(status().isOk())
           .andExpect(view().name("/index"))
           .andDo(print());
  }
}