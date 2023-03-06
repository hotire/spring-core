package com.github.hotire.springcore.bean.inner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
@Configuration
public class InnerClassConfig {

    @Component
    class Inner {

        public Inner() {
            InnerClassConfig.log.info("hello InnerClassConfig");
        }
    }
}
