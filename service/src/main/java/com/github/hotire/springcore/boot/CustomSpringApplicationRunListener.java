package com.github.hotire.springcore.boot;

import java.time.Duration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;

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

//    @Override
//    public void starting() {
//        log.info("starting");
//    }
//
//    @Override
//    public void environmentPrepared(ConfigurableEnvironment environment) {
//        log.info("environmentPrepared");
//    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        log.info("started");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        log.info("ready");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("failed");
    }
}
