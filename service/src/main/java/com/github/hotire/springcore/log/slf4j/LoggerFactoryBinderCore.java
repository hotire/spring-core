package com.github.hotire.springcore.log.slf4j;

import ch.qos.logback.classic.LoggerContext;
import org.slf4j.ILoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.slf4j.spi.LoggerFactoryBinder;

/**
 * @see LoggerFactoryBinder
 * @see StaticLoggerBinder
 */
public class LoggerFactoryBinderCore {

    /**
     * @see StaticLoggerBinder#defaultLoggerContext
     */
    private LoggerContext defaultLoggerContext = new LoggerContext();

    /**
     * @see LoggerFactoryBinder#getLoggerFactory()
     * @see StaticLoggerBinder#getLoggerFactory()
     */
    public ILoggerFactory getLoggerFactory() {
        return StaticLoggerBinder.getSingleton().getLoggerFactory();
    }

}
