package com.github.hotire.springcore.scan;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

/**
 * @see AnnotatedBeanDefinitionReader
 */
public class AnnotatedBeanDefinitionReaderCore {

    /**
     * @see AnnotatedBeanDefinitionReader 생성자에서
     * @see AnnotationConfigUtils 를 통해 Annotation 관련 post processors를 등록합니다.
     *
     * 대표적으로
     * @see AutowiredAnnotationBeanPostProcessor
     * @see CommonAnnotationBeanPostProcessor
     * @see ConfigurationClassPostProcessor
     */
    public AnnotatedBeanDefinitionReaderCore(BeanDefinitionRegistry registry) {
        AnnotationConfigUtils.registerAnnotationConfigProcessors(registry, null);
    }

}
