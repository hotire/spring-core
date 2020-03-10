package com.kakao.hotire.springcore.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ConditionalConfig {

    @ConditionalOnProperty(prefix = "hotire", value = "enabled", matchIfMissing = true)
    public static class OnProperty implements InitializingBean {
        @Override
        public void afterPropertiesSet() throws Exception {
            log.debug("OnProperty");
        }
    }
}
