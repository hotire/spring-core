package com.github.hotire.springcore.metrics;

import org.springframework.core.metrics.StartupStep;

/**
 * @see org.springframework.core.metrics.ApplicationStartup
 * @see org.springframework.core.metrics.DefaultApplicationStartup
 * @see org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup
 */
public class ApplicationStartupCore {

    /**
     * @see org.springframework.core.metrics.DefaultApplicationStartup#start(String) 
     */
    public StartupStep start(String name) {
        return null;
    }
}
