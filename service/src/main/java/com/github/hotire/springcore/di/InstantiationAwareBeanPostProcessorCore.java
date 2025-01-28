package com.github.hotire.springcore.di;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.annotation.Resource;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.InjectionMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.lang.Nullable;
import org.springframework.util.ReflectionUtils;

/**
 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#populateBean(String, RootBeanDefinition, BeanWrapper)
 * @see org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor
 * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor
 * @see org.springframework.context.annotation.CommonAnnotationBeanPostProcessor
 */
public class InstantiationAwareBeanPostProcessorCore {

    /**
     * @see AutowiredAnnotationBeanPostProcessor#autowiredAnnotationTypes
     */
    private final Set<Class<? extends Annotation>> autowiredAnnotationTypes = new LinkedHashSet<>(4) {
        {
            this.add(Autowired.class);
            this.add(Value.class);
        }
    };

    /**
     * @see InstantiationAwareBeanPostProcessor#postProcessProperties(PropertyValues, Object, String)
     * @see AutowiredAnnotationBeanPostProcessor#postProcessProperties(PropertyValues, Object, String)
     * @see CommonAnnotationBeanPostProcessor#postProcessProperties(PropertyValues, Object, String)
     */
    @Resource
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {

        return null;
    }

    /**
     * @see AutowiredAnnotationBeanPostProcessor#findAutowiringMetadata(String, Class, PropertyValues)
     */
    private InjectionMetadata findAutowiringMetadata(String beanName, Class<?> clazz, @Nullable PropertyValues pvs) {
        return buildAutowiringMetadata(clazz);
    }

    /**
     * @see AutowiredAnnotationBeanPostProcessor#buildAutowiringMetadata(Class)
     */
    private InjectionMetadata buildAutowiringMetadata(Class<?> clazz) {

        ReflectionUtils.doWithLocalFields(clazz, field -> {

        });

        ReflectionUtils.doWithLocalMethods(clazz, method -> {

        });

        return null;
    }

    /**
     * @see AutowiredAnnotationBeanPostProcessor#findAutowiredAnnotation(AccessibleObject)
     */
    private MergedAnnotation<?> findAutowiredAnnotation(AccessibleObject ao) {
        return null;
    }
}
