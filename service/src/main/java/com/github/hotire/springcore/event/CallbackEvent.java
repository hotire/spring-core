package com.github.hotire.springcore.event;

import java.util.function.Consumer;

import lombok.Getter;
import lombok.Setter;

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
