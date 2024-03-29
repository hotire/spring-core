package com.github.hotire.springcore.event;

import java.util.Objects;
import java.util.Optional;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.ResolvableType;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.lang.Nullable;

public class AsyncApplicationEventMulticaster extends SimpleApplicationEventMulticaster {
    public AsyncApplicationEventMulticaster(final AsyncTaskExecutor asyncTaskExecutor) {
        setTaskExecutor(Objects.requireNonNull(asyncTaskExecutor));
    }

    @Override
    public void multicastEvent(final ApplicationEvent event, @Nullable ResolvableType eventType) {
        final ResolvableType type = Optional.ofNullable(eventType).orElseGet(() -> ResolvableType.forInstance(event));
        getApplicationListeners(event, type).forEach(listener ->
                                                             Optional.ofNullable(getTaskExecutor())
                                                                     .filter(executor -> checkAsyncEvent(event))
                                                                     .ifPresentOrElse(
                                                                             executor -> executor.execute(() -> invokeListener(listener, event)),
                                                                             () -> invokeListener(listener, event))
        );
    }

    protected boolean checkAsyncEvent(final ApplicationEvent event) {
        if (event instanceof com.github.hotire.springcore.event.AsyncApplicationEvent) {
            return ((AsyncApplicationEvent) event).isAsync();
        }
        return false;
    }
}
