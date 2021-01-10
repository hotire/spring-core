package com.kakao.hotire.springcore.factory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class ToolFactoryTest {

    @Autowired
    private Tool tool;
    @Autowired
    private ApplicationContext context;

    @Test
    void di() {
        // given
        final Tool result = context.getBean(Tool.class);

        // then
        assertThat(tool).isNotNull();
        assertThat(tool).isEqualTo(result);
    }

}