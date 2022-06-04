package com.github.hotire.springcore.bean.register.post_processor;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

/**
 * @see BeanDefinitionRegistryPostProcessor
 * @see ConfigurationClassPostProcessor
 *
 * BeanFactoryPostProcessor 확장으로 BeanFactoryPostProcessor 호출하기 전에
 * 추가적으로 Bean을 등록할 수 있다.
 */
public class BeanDefinitionRegistryPostProcessorCore {

    /**
     * @see BeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry(BeanDefinitionRegistry) 
     * @see ConfigurationClassPostProcessor#postProcessBeanDefinitionRegistry(BeanDefinitionRegistry) 
     */
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
        
    }

    /**
     * @see ConfigurationClassPostProcessor#processConfigBeanDefinitions(BeanDefinitionRegistry) 
     */
    public void processConfigBeanDefinitions(BeanDefinitionRegistry registry) {
        
    }
}
