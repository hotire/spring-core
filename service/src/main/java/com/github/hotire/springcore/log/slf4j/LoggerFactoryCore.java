package com.github.hotire.springcore.log.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @see LoggerFactory
 */
public class LoggerFactoryCore {

    /**
     * @see LoggerFactory#getLogger(String)
     */
    public static Logger getLogger(String name) {
        return LoggerFactory#getLogger(name);
    }
}
