package com.github.hotire.springcore.event;

import org.springframework.context.ApplicationEventPublisher;

import lombok.RequiredArgsConstructor;

@EventComponent
@RequiredArgsConstructor
public class EntityEventPublisher {
    private final ApplicationEventPublisher publisher;

    public void publish(final Entity entity) {
        publisher.publishEvent(new EntityEvent(entity));
    }
}
