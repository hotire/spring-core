package com.github.hotire.springcore.bean_factory_post_processor.example;


import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

public class SimpleClassPathScanningCandidateComponentProvider extends ClassPathScanningCandidateComponentProvider {

    public SimpleClassPathScanningCandidateComponentProvider() {
        addIncludeFilter(new AnnotationTypeFilter(SimpleService.class));
    }

    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }
}
