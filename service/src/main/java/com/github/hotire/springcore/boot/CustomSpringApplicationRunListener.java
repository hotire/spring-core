package com.github.hotire.springcore.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *  @see org.springframework.boot.SpringApplicationRunListeners;
 *  @see org.springframework.boot.context.event.EventPublishingRunListener;
 */
@Slf4j
@RequiredArgsConstructor
public class CustomSpringApplicationRunListener implements SpringApplicationRunListener {

    private final SpringApplication application;

    private final String[] args;

    @Override
    public void starting() {
        log.info("starting");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        log.info("environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info("started");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info("running");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("failed");
    }
}
