package com.github.hotire.springcore.bean.init;

import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class BeanInitCore {

    /**
     * @see AbstractAutowireCapableBeanFactory#initializeBean(String, Object, RootBeanDefinition) 
     * @see InitDestroyAnnotationBeanPostProcessor#postProcessBeforeInitialization(Object, String)    1. PostConstruct
     * @see AbstractAutowireCapableBeanFactory#invokeInitMethods(String, Object, RootBeanDefinition)  2. InitializingBean
     * @see AbstractAutowireCapableBeanFactory#invokeCustomInitMethod(String, Object, RootBeanDefinition)  3. @Bean(init)
     */
    public void init() {
    }
}
