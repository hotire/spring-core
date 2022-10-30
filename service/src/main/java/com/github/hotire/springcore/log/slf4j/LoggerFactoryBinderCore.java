package com.github.hotire.springcore.log.slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.slf4j.impl.StaticLoggerBinder;

/**
 * @see LoggerFactoryBinder
 * @see StaticLoggerBinder
 */
public class LoggerFactoryBinderCore {

    /**
     * @see LoggerFactoryBinder#getLoggerFactory()
     * @see StaticLoggerBinder#getLoggerFactory()
     */
    public ILoggerFactory getLoggerFactory() {
        return StaticLoggerBinder.getSingleton().getLoggerFactory();
    }

}
