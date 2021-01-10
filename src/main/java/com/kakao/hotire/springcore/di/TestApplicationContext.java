package com.kakao.hotire.springcore.di;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;

public class TestApplicationContext {

  @Getter
  public final Map<Class<?>, Object> beanMap;

  public TestApplicationContext(Map<Class<?>, Object> beanMap) {
    this.beanMap = beanMap;
  }

  public TestApplicationContext() {
    this.beanMap = new HashMap<>();
  }

  @SuppressWarnings("unchecked")
  public <T> T getBean(Class<T> type) {
    return Optional.ofNullable(beanMap.get(type)).map(o -> (T)o).orElseGet(() -> {
      final T instance = createInstance(type);
      Arrays.stream(type.getDeclaredFields())
        .filter(field -> field.isAnnotationPresent(Autowired.class))
        .forEach(field -> {
           final Object fieldInstance = getBean(field.getType());
           field.setAccessible(true);
          try {
            field.set(instance, fieldInstance);
          } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
          }
        });
      beanMap.put(type, instance);
      return instance;
    });
  }

  @SuppressWarnings("unchecked")
  public <T> T createInstance(Class<T> type) {
    try {
      final Constructor<?>[] candidates = type.getDeclaredConstructors();
      for (Constructor candidate : candidates) {
        return (T) candidate.newInstance(
            Arrays.stream(candidate.getParameterTypes())
                .map(beanMap::get)
                .toArray()
        );
      }
      throw new IllegalStateException("Can not found constructor of " + type.getName());
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }
}
