package com.kakao.hotire.springcore.event;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationEventConfigurationTest {

    @Test
    void asyncApplicationEventMulticaster() {
        // given
        final ApplicationEventConfiguration configuration = new ApplicationEventConfiguration();

        // when
        final AsyncApplicationEventMulticaster result = configuration.asyncApplicationEventMulticaster();

        // then
        assertThat(result).isNotNull();
    }
}