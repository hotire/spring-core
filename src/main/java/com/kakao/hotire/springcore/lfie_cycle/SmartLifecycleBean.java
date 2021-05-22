package com.kakao.hotire.springcore.lfie_cycle;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SmartLifecycleBean implements SmartLifecycle {
    @Override
    public void start() {
        log.info("SmartLifecycleBean start");
    }

    @Override
    public void stop() {
        log.info("SmartLifecycleBean stop");
    }

    @Override
    public boolean isRunning() {
        log.info("SmartLifecycleBean isRunning");
        return false;
    }
}
