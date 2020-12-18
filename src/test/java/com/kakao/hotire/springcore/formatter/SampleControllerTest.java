package com.kakao.hotire.springcore.formatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@Import(PersonFormatter.class)
class SampleControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void hello() throws Exception {
    mockMvc.perform(get("/sample/tire.ho"))
           .andDo(print())
           .andExpect(status().isOk())
           .andExpect(content().string("hello tire.ho, by PersonFormatter"));
  }
}