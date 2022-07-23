package com.github.hotire.springcore.bean.register.post_processor.config;

import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.core.annotation.AnnotationAttributes;

/**
 * @see org.springframework.context.annotation.ComponentScanAnnotationParser
 */
public class ComponentScanAnnotationParserCore {

    /**
     * @see org.springframework.context.annotation.ComponentScanAnnotationParser#parse(AnnotationAttributes, String) 
     */
    public Set<BeanDefinitionHolder> parse(AnnotationAttributes componentScan, String declaringClass) {
        return Set.of();
    }
}
