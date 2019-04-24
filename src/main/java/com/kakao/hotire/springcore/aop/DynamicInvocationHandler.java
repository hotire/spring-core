package com.kakao.hotire.springcore.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {
  private Object delegate;

  public DynamicInvocationHandler(Object delegate) {
    this.delegate = delegate;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // before
    final Object result = method.invoke(delegate, args);
    // after
    return result;
  }
}