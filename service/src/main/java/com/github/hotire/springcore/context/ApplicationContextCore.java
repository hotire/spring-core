package com.github.hotire.springcore.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.DefaultLifecycleProcessor;

import lombok.Getter;

/**
 * @see ApplicationContext
 * @see ConfigurableApplicationContext
 * @see AbstractApplicationContext
 */
public class ApplicationContextCore {

    @Getter
    private final LifecycleProcessor lifecycleProcessor = new DefaultLifecycleProcessor();

    /**
     * @see ConfigurableApplicationContext#refresh()
     * @see AbstractApplicationContext#refresh()
     */
    public void refresh() throws BeansException, IllegalStateException {

        // Last step: publish corresponding event.
        finishRefresh();

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

    /**
     * @see AbstractApplicationContext#finishRefresh()
     */
    protected void finishRefresh() {
        getLifecycleProcessor().onRefresh();
    }

}
