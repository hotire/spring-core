package com.github.hotire.springcore.bean_factory_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor
 * @see org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor
 * @see org.springframework.context.annotation.ConfigurationClassPostProcessor
 * Factory hook that allows for custom modification of an application context's bean definitions, adapting the bean property values of the context's underlying bean factory.
 *
 * BeanFactory의 Bean 속성을 사용자 정의로 수정할 수 있다.
 */
public class BeanFactoryPostProcessorCore {

    /**
     * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(ConfigurableListableBeanFactory)
     *
     * BeanFactory의 초기화 이후, 모든 Bean definitions은 Load되었지만 아직 Bean이 생성되지 않아 수정할 수 있다.
     * This allows for overriding or adding properties even to eager-initializing beans.
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
