package com.kakao.hotire.springcore.lfie_cycle;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationLifeCycleEventListener {

    @EventListener(ContextRefreshedEvent.class)
    public void onRefresh(final ContextRefreshedEvent event) {
        log.info("ContextRefreshedEvent");
    }

    @EventListener(ContextClosedEvent.class)
    public void onClose(final ContextClosedEvent event) {
        log.info("ContextClosedEvent");
    }

}
