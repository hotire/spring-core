package com.kakao.hotire.springcore.factory;

import com.kakao.hotire.springcore.di.TestService;
import com.kakao.hotire.springcore.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ToolFactoryTest {

    @Autowired
    private Tool tool;
    @Autowired
    private ApplicationContext context;

    @Test
    void di() {

        final Tool result = context.getBean(Tool.class);
        final HelloService testService = context.getBean(HelloService.class);

        assertThat(tool).isNotNull();
    }

}