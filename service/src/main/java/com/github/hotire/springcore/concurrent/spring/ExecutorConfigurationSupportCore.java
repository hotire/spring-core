package com.github.hotire.springcore.concurrent.spring;

import java.util.concurrent.ExecutorService;
import org.springframework.scheduling.concurrent.ExecutorConfigurationSupport;

/**
 * @see ExecutorConfigurationSupport
 */
public class ExecutorConfigurationSupportCore {

    /**
     * @see ExecutorConfigurationSupport#waitForTasksToCompleteOnShutdown
     */
    private boolean waitForTasksToCompleteOnShutdown = false;


    /**
     * @see ExecutorConfigurationSupport#shutdown()
     */
    public void shutdown() {

    }

    /**
     * @see ExecutorConfigurationSupport#awaitTerminationIfNecessary(ExecutorService)
     */
    public void awaitTerminationIfNecessary(ExecutorService executorService) {

    }

}
