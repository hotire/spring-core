package com.kakao.hotire.springcore.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AsyncApplicationEventTest {

    @Test
    void isAsync() {
        // given
        final AsyncApplicationEvent event = new AsyncApplicationEvent(new Object());

        // when
        final boolean result = event.isAsync();

        // then
        assertThat(result).isTrue();
    }
}