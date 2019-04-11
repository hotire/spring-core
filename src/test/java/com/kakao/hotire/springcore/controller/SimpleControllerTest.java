package com.kakao.hotire.springcore.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.kakao.hotire.springcore.config.RoutingConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RoutingConfig.class)
public class SimpleControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void whenSimpleUrlMapping_thenMappedOK() throws Exception {
    mockMvc.perform(get("/simple"))
      .andExpect(status().isOk())
      .andExpect(view().name("/index"));
  }
}