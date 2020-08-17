package com.kakao.hotire.springcore.event;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class CallbackEventTest {

    @Test
    void getCallback() {
        // given
        final CallbackEvent<?> callbackEvent = new CallbackEvent<>(mock(Object.class));

        // when
        callbackEvent.setCallback(mock(Consumer.class));
        final Consumer<?> result = callbackEvent.getCallback();

        // then
        assertThat(result).isNotNull();
    }

}