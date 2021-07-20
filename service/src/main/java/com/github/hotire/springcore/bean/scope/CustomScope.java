package com.github.hotire.springcore.bean.scope;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class CustomScope implements Scope {

    public static final String CUSTOM_SCOPE = "custom";

    public static final Map<String, Object> SCOPE_MAP = new ConcurrentHashMap<>();
    public static final Map<String, Runnable> DESTRUCTION_CALLBACK = new ConcurrentHashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        return Optional.ofNullable(SCOPE_MAP.get(name))
                       .orElseGet(() -> SCOPE_MAP.put(name, objectFactory.getObject()));
    }

    @Override
    public Object remove(String name) {
        return SCOPE_MAP.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        DESTRUCTION_CALLBACK.put(name, callback);
    }

    @Override
    public Object resolveContextualObject(String key) {
        return Map.copyOf(SCOPE_MAP);
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
