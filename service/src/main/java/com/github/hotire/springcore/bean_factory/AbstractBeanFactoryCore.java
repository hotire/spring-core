package com.github.hotire.springcore.bean_factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.lang.Nullable;

/**
 * @see AbstractBeanFactory
 */
public class AbstractBeanFactoryCore {


    /**
     * @see AbstractBeanFactory#doGetBean(String, Class, Object[], boolean) 
     */
    protected <T> T doGetBean(
        String name, @Nullable Class<T> requiredType, @Nullable Object[] args, boolean typeCheckOnly)
        throws BeansException {
        return null;
    }
}
