package com.github.hotire.springcore.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

public class AsyncApplicationEvent extends ApplicationEvent {

    @Getter
    private final boolean async;

    public AsyncApplicationEvent(Object source) {
        this(source, true);
    }

    public AsyncApplicationEvent(Object source, final boolean async) {
        super(source);
        this.async = async;
    }
}
