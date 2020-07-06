package com.kakao.hotire.springcore.event;

import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.AsyncTaskExecutor;

import java.util.Objects;

public class AsyncApplicationEventMulticaster extends SimpleApplicationEventMulticaster {
    public AsyncApplicationEventMulticaster(final AsyncTaskExecutor asyncTaskExecutor) {
        setTaskExecutor(Objects.requireNonNull(asyncTaskExecutor));
    }
}
