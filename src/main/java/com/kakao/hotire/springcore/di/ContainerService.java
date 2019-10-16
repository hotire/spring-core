package com.kakao.hotire.springcore.di;

import java.lang.reflect.InvocationTargetException;

public class ContainerService {

  public static <T> T getBean(Class<T> type) {
    return createInstance(type);
  }

  public static <T> T createInstance(Class<T> type) {
    try {
      return type.getConstructor(null).newInstance();
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }
}
