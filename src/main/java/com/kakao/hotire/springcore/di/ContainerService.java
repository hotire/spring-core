package com.kakao.hotire.springcore.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ContainerService {

  public static Map<Class, Object> BEAN_MAP = new HashMap<>();

  public static <T> T getBean(Class<T> type) {
    return Optional.ofNullable(BEAN_MAP.get(type)).map(o -> (T)o).orElseGet(() -> {
      final T instance = createInstance(type);
      Arrays.stream(type.getDeclaredFields())
        .filter(field -> field.isAnnotationPresent(Inject.class))
        .forEach(field -> {
           Object fieldInstance = getBean(field.getType());
           field.setAccessible(true);
          try {
            field.set(instance, fieldInstance);
          } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
          }
        });
      BEAN_MAP.put(type, instance);
      return instance;
    });
  }

  public static <T> T createInstance(Class<T> type) {
    try {
      return type.getConstructor(null).newInstance();
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }
}
