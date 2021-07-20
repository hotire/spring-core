package com.github.hotire.springcore.event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.TestConstructor;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
class EntityEventListenerTest {
    private final ApplicationEventPublisher publisher;

    @Test
    void consume() {
        // given
        final AtomicBoolean atomicBoolean = mock(AtomicBoolean.class);
        final CallbackEvent event = new CallbackEvent(atomicBoolean);
        event.setCallback(o -> atomicBoolean.set(true));

        // when
        publisher.publishEvent(new AsyncApplicationEvent("data"));


        // then
        verify(atomicBoolean, timeout(2000)).set(true);
    }
}