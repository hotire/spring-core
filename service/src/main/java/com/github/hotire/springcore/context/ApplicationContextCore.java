package com.github.hotire.springcore.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @see ApplicationContext
 * @see ConfigurableApplicationContext
 * @see AbstractApplicationContext
 */
public class ApplicationContextCore {

    /**
     * @see ConfigurableApplicationContext#refresh() 
     * @see AbstractApplicationContext#refresh() 
     */
    public void refresh() throws BeansException, IllegalStateException {

    }
    /**
     * @see AbstractApplicationContext#postProcessBeanFactory(ConfigurableListableBeanFactory) 
     */
    protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
    }

    /**
     * @see AbstractApplicationContext#invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory)
     */
    protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        
    }

}
