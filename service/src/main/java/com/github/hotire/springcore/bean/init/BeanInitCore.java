package com.github.hotire.springcore.bean.init;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanInitCore implements InitializingBean {

    /**
     * @see AbstractAutowireCapableBeanFactory#initializeBean(String, Object, RootBeanDefinition)
     * @see InitDestroyAnnotationBeanPostProcessor#postProcessBeforeInitialization(Object, String)    1. PostConstruct
     * @see AbstractAutowireCapableBeanFactory#invokeInitMethods(String, Object, RootBeanDefinition)  2. InitializingBean
     * @see AbstractAutowireCapableBeanFactory#invokeCustomInitMethod(String, Object, RootBeanDefinition)  3. @Bean(init)
     */
    public void init() {
    }

    /**
     * @see InitDestroyAnnotationBeanPostProcessor#postProcessBeforeDestruction(Object, String)
     */
    @PreDestroy
    public void destroy() {
        log.error("destroy");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("1. postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("2. InitializingBean");
    }

    public void customInit() {
        log.info("3. customInit");
    }
}
