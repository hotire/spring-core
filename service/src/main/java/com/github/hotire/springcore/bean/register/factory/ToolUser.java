package com.github.hotire.springcore.bean.register.factory;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ToolUser {
    private final Tool toolFactory;
    private final Tool toolFactory2;
}
