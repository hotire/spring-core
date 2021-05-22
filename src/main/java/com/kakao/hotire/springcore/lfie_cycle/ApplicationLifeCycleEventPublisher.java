package com.kakao.hotire.springcore.lfie_cycle;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ApplicationLifeCycleEventPublisher implements ApplicationRunner {

    private final ConfigurableApplicationContext context;

    public void start() {
        context.start();
    }

    public void stop() {
        context.stop();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println();
    }
}
