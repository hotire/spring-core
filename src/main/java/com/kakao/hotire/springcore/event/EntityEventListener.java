package com.kakao.hotire.springcore.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@EventComponent
public class EntityEventListener {

    @EventListener
    public void consume(final CallbackEvent event) throws InterruptedException {
        Thread.sleep(1000);
        log.info("async : {}", event);
        event.getCallback().accept(event.getSource());
    }

    @EventListener
    public void consume(final EntityEvent entityEvent) {
        log.info("event : {}", entityEvent);
    }

    @EventListener
    public void consume(final ApplicationEvent event) {
        log.info("event : {}", event);
    }
}
