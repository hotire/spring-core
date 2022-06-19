package com.github.hotire.springcore.di;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
 */
public class AutowiredAnnotationBeanPostProcessorCore {

    /**
     * DI field, setter method
     * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#populateBean(String, RootBeanDefinition, BeanWrapper)
     * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor#postProcessProperties(PropertyValues, Object, String)
     */
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) {
        return null;
    }
}
