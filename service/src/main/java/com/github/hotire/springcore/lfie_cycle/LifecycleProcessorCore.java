package com.github.hotire.springcore.lfie_cycle;

import org.springframework.context.LifecycleProcessor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.DefaultLifecycleProcessor;

/**
 * @see LifecycleProcessor
 */
public class LifecycleProcessorCore {

    /**
     * @see AbstractApplicationContext#finishRefresh()
     * @see LifecycleProcessor#onRefresh()
     * @see DefaultLifecycleProcessor#onRefresh()
     */
    public void onRefresh() {
        startBeans(true);
    }

    private void startBeans(boolean autoStartupOnly) {

    }
}
