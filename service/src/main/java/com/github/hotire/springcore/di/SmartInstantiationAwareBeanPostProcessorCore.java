package com.github.hotire.springcore.di;

import java.lang.reflect.Constructor;

import org.springframework.beans.BeansException;

/**
 * @see org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor
 */
public class SmartInstantiationAwareBeanPostProcessorCore {

    /**
     * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#determineConstructorsFromBeanPostProcessors(Class, String) 
     * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor#determineCandidateConstructors(Class, String) 
     */
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName)
            throws BeansException {
        return null;
    }
}
