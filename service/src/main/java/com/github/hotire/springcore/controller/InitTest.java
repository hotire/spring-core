package com.github.hotire.springcore.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitTest {

    @Bean(initMethod = "init")
    public InitBean initBean() {
        return new InitBean();
    }
    public static class InitBean {
        public void init() {
            System.out.println("InitBean");
        }
    }
}
