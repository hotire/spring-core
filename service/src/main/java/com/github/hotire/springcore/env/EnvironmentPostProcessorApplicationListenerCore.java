package com.github.hotire.springcore.env;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.env.EnvironmentPostProcessorApplicationListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @see EnvironmentPostProcessorApplicationListener
 */
public class EnvironmentPostProcessorApplicationListenerCore {

    /**
     * @see org.springframework.boot.SpringApplicationRunListeners#environmentPrepared(ConfigurableBootstrapContext, ConfigurableEnvironment)
     * @see  org.springframework.boot.context.event.EventPublishingRunListener#environmentPrepared(ConfigurableBootstrapContext, ConfigurableEnvironment) 
     * @see EnvironmentPostProcessorApplicationListener#onApplicationEvent(ApplicationEvent)
     */
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
//            onApplicationEnvironmentPreparedEvent((ApplicationEnvironmentPreparedEvent) event);
        }
        if (event instanceof ApplicationPreparedEvent) {
//            onApplicationPreparedEvent();
        }
        if (event instanceof ApplicationFailedEvent) {
//            onApplicationFailedEvent();
        }
    }
}
