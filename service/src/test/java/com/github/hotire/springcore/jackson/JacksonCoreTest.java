package com.github.hotire.springcore.jackson;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class JacksonCoreTest {

    @Test
    void toJson() throws JsonProcessingException {
        // given
        final String expected = "{\"name\":\"hello\",\"enabled\":true}";
        final ObjectMapper mapper = new ObjectMapper();
        final JacksonCore jacksonCore = new JacksonCore("hello", true);

        // when
        final String result = mapper.writeValueAsString(jacksonCore);

        // then
        assertThat(result).isEqualTo(expected);
    }
}