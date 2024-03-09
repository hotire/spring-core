package com.github.hotire.springcore.bean.definition;

import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

/**
 * @see BeanDefinition
 * @see AnnotatedBeanDefinition
 * @see AbstractBeanDefinition
 * @see GenericBeanDefinition
 */
public class BeanDefinitionCore {

    /**
     * @see AbstractBeanDefinition#instanceSupplier
     */
    private Supplier<?> instanceSupplier;
}
