package com.github.hotire.springcore.bean.error;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class BeanFactoryError {

    private final ApplicationContext context;

    @PostConstruct
    public void init() {
        try {
            context.getBean(NotFound.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    static class NotFound { }

}
