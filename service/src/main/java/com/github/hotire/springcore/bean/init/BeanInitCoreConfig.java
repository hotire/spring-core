package com.github.hotire.springcore.bean.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInitCoreConfig {

    @Bean(initMethod = "customInit")
    public BeanInitCore beanInitCore() {
        return new BeanInitCore();
    }
}
