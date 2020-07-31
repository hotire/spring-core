package com.kakao.hotire.springcore.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

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
