package com.github.hotire.springcore.boot;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @see org.springframework.boot.SpringApplicationRunListeners;
 */
public class SpringApplicationRunListenersCore {

    /**
     * @see org.springframework.boot.SpringApplicationRunListeners#contextPrepared(ConfigurableApplicationContext)
     */
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    /**
     * @see org.springframework.boot.SpringApplicationRunListeners#environmentPrepared(ConfigurableBootstrapContext, ConfigurableEnvironment)
     */
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {

    }
}
