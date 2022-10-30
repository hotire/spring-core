package com.github.hotire.springcore.log.logback;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import java.util.Map;

/**
 * @see LoggerContext
 */
public class LoggerContextCore {

    private Map<String, Logger> loggerCache;

    /**
     * @see LoggerContext#getLogger(String) 
     */
    public final Logger getLogger(final String name) {
        return loggerCache.get(name);
    }
}
