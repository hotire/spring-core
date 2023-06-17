package com.github.hotire.springcore.di;

import java.util.Set;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
 */
public class AutowiredAnnotationBeanPostProcessorCore {

    /**
     * DI field, setter method
     * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#populateBean(String, RootBeanDefinition, BeanWrapper)
     * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor#postProcessProperties(PropertyValues, Object, String)
     * @see org.springframework.beans.factory.annotation.InjectionMetadata#inject(Object, String, PropertyValues)
     * @see org.springframework.beans.factory.annotation.InjectionMetadata.InjectedElement#inject(Object, String, PropertyValues)
     * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.AutowiredFieldElement#inject(Object, String, PropertyValues)
     * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.AutowiredMethodElement#inject(Object, String, PropertyValues)
     * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor#resolvedCachedArgument(String, Object)
     * @see org.springframework.beans.factory.support.DefaultListableBeanFactory#resolveDependency(DependencyDescriptor, String, Set, TypeConverter)
     */
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) {
        return null;
    }
}
