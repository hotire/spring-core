package com.kakao.hotire.springcore.lfie_cycle;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LifecycleBean implements Lifecycle {
    @Override
    public void start() {
        log.info("LifecycleBean start");
    }

    @Override
    public void stop() {
        log.info("LifecycleBean stop");
    }

    @Override
    public boolean isRunning() {
        log.info("LifecycleBean isRunning");
        return false;
    }
}
