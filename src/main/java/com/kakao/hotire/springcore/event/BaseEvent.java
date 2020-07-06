package com.kakao.hotire.springcore.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class BaseEvent extends ApplicationEvent {

    @Getter
    private boolean async;

    public BaseEvent(Object source) {
        super(source);
    }
}
