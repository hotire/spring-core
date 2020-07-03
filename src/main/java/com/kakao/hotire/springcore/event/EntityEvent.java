package com.kakao.hotire.springcore.event;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;


@ToString
@Getter
public class EntityEvent extends ApplicationEvent {
    private final Entity entity;
    public EntityEvent(Object source) {
        super(source);
        this.entity = (Entity) source;
    }
}
