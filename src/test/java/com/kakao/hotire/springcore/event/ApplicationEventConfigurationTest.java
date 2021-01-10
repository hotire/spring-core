package com.kakao.hotire.springcore.event;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.event.AbstractApplicationEventMulticaster;
import org.springframework.core.task.AsyncTaskExecutor;

class ApplicationEventConfigurationTest {

    @Test
    void asyncApplicationEventMulticaster() {
        // given
        final ApplicationEventConfiguration configuration = new ApplicationEventConfiguration();

        // when
        final AbstractApplicationEventMulticaster result = configuration.asyncApplicationEventMulticaster();

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void asyncTaskExecutor() {
        // given
        final ApplicationEventConfiguration configuration = new ApplicationEventConfiguration();

        // when
        final AsyncTaskExecutor result = configuration.asyncTaskExecutor();

        // then
        assertThat(result).isNotNull();
    }
}