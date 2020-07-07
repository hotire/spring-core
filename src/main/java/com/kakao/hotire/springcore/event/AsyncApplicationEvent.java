package com.kakao.hotire.springcore.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class AsyncApplicationEvent extends ApplicationEvent {

    @Getter
    private boolean async = true;

    public AsyncApplicationEvent(Object source) {
        super(source);
    }
}
