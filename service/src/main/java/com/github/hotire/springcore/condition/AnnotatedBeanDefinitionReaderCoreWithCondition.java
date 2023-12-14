package com.github.hotire.springcore.condition;

import java.lang.annotation.Annotation;
import java.util.function.Supplier;
import org.springframework.beans.factory.config.BeanDefinitionCustomizer;
import org.springframework.lang.Nullable;

import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @see AnnotatedBeanDefinitionReader
 */
public class AnnotatedBeanDefinitionReaderCoreWithCondition {

    /**
     * @see AnnotatedBeanDefinitionReader#doRegisterBean(Class, String, Class[], Supplier, BeanDefinitionCustomizer[]) 
     */
    private <T> void doRegisterBean(Class<T> beanClass, @Nullable String name,
        @Nullable Class<? extends Annotation>[] qualifiers, @Nullable Supplier<T> supplier,
        @Nullable BeanDefinitionCustomizer[] customizers) {
        
    }

}
