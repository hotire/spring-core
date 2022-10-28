package com.github.hotire.springcore.log.slf4j;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import ch.qos.logback.classic.LoggerContext;

/**
 * @see ILoggerFactory
 * @see LoggerContext
 */
public interface ILoggerFactoryCore {


    /**
     * @see ILoggerFactory#getLogger(String)
     * @see LoggerContext#getLogger(String) 
     */
     Logger getLogger(String name);
}
