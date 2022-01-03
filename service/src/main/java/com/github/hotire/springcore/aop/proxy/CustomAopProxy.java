package com.github.hotire.springcore.aop.proxy;

import org.springframework.aop.framework.AopProxy;

/**
 * @see AopProxy
 * @see org.springframework.aop.framework.JdkDynamicAopProxy
 * @see org.springframework.aop.framework.CglibAopProxy
 */
public class CustomAopProxy implements AopProxy {
    @Override
    public Object getProxy() {
        return this;
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return this;
    }
}
