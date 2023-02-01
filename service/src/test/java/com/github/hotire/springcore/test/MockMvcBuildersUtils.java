package com.github.hotire.springcore.test;

import com.github.hotire.springcore.exception.ExceptionHandlerController;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MockMvcBuildersUtils {
    public static MockMvc mockMvc(Object... controllers) {
        return MockMvcBuilders
            .standaloneSetup(controllers)
            .setControllerAdvice(new ExceptionHandlerController(new DefaultErrorAttributes()))
            .build();
    }
}
