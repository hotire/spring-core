package com.github.hotire.springcore.di;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

public class TestController {
    @Autowired
    @Getter
    private TestService testService;
}
