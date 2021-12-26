package com.github.hotire.springcore.aop.proxy.ex;

import org.springframework.context.ApplicationContext;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestService {
    private final ApplicationContext context;

    public void service() {
        context.getBean(TestService.class).transaction();
    }

//    @Transactional
    public void transaction() {
        // ..
    }
}
