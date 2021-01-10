package com.kakao.hotire.springcore.event;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collection;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.ResolvableType;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

class AsyncApplicationEventMulticasterTest {

    @MethodSource("provideEvent")
    @ParameterizedTest
    void checkAsyncEvent(final ApplicationEvent event, final boolean expected) {
        // given
        final AsyncTaskExecutor taskExecutor = mock(AsyncTaskExecutor.class);
        final AsyncApplicationEventMulticaster multicaster = new AsyncApplicationEventMulticaster(taskExecutor);

        // when
        final boolean result = multicaster.checkAsyncEvent(event);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @MethodSource("provideEvent")
    @ParameterizedTest
    void multicastEvent(final ApplicationEvent event) {
        // given
        final AsyncTaskExecutor taskExecutor = new SimpleAsyncTaskExecutor();
        final ApplicationListener listener = mock(ApplicationListener.class);
        final AsyncApplicationEventMulticaster multicaster = new AsyncApplicationEventMulticaster(taskExecutor) {
            @Override
            protected Collection<ApplicationListener<?>> getApplicationListeners(
                    ApplicationEvent event, ResolvableType eventType) {
                return Lists.newArrayList(listener);
            }
        };

        // when
        multicaster.multicastEvent(event);

        // then
        verify(listener, times(1)).onApplicationEvent(event);
    }

    private static Stream<Arguments> provideEvent() {
        return Stream.of(
                Arguments.of(new AsyncApplicationEvent(new Object()), true),
                Arguments.of(new ApplicationEvent(new Object()) {}, false)
        );
    }
}