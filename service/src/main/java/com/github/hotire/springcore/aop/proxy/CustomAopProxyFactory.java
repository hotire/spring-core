package com.github.hotire.springcore.aop.proxy;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopConfigException;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.AopProxyFactory;

/**
 * @see org.springframework.aop.framework.AopProxyFactory
 * @see org.springframework.aop.framework.DefaultAopProxyFactory
 *
 * ProxyFactory implements ProxyCreatorSupport use DefaultAopProxyFactory
 *
 */
public class CustomAopProxyFactory implements AopProxyFactory {
    @Override
    public AopProxy createAopProxy(AdvisedSupport config) throws AopConfigException {
        return null;
    }
}
