package com.kakao.hotire.springcore.config;

import com.kakao.hotire.springcore.controller.SimpleRestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Slf4j
@Configuration
public class ConditionalConfig {

    @Configuration
    @ConditionalOnProperty(prefix = "hotire", value = "enabled", matchIfMissing = true)
    public static class OnProperty implements InitializingBean {
        @Override
        public void afterPropertiesSet() throws Exception {
            log.debug("OnProperty");
        }
    }

    @Configuration
    @ConditionalOnClass(DispatcherServlet.class)
    public static class OnClass implements InitializingBean{
        @Override
        public void afterPropertiesSet() throws Exception {
            log.debug("OnClass");
        }
    }

    @Configuration
    @ConditionalOnBean(SimpleRestController.class)
    public static class OnBean implements InitializingBean{
        @Override
        public void afterPropertiesSet() throws Exception {
            log.debug("OnClass");
        }
    }

    @Configuration
    @ConditionalOnMissingProfile(value = "beta")
    public static class OnMissingProfile implements InitializingBean{
        @Override
        public void afterPropertiesSet() throws Exception {
            log.debug("OnClass");
        }
    }
}
