package com.kakao.hotire.springcore.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntityEventPublisher {
    private final ApplicationEventPublisher publisher;

    public void publish(final Entity entity) {
        publisher.publishEvent(new EntityEvent(entity));
    }
}
