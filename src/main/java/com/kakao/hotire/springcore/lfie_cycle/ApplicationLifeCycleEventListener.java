package com.kakao.hotire.springcore.lfie_cycle;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ApplicationLifeCycleEventListener {

    @EventListener(ContextRefreshedEvent.class)
    public void onRefresh(final ContextRefreshedEvent event) {
        log.info("ContextRefreshedEvent");
    }
}
