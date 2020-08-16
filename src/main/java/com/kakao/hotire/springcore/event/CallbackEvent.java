package com.kakao.hotire.springcore.event;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

public class CallbackEvent<T> extends AsyncApplicationEvent {

    @Getter @Setter
    private Consumer<T> callback;

    public CallbackEvent(Object source) {
        super(source);
    }

    public CallbackEvent(Object source, boolean async) {
        super(source, async);
    }
}
