package com.github.hotire.springcore.log.slf4j;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * @see ILoggerFactory
 */
public interface ILoggerFactoryCore {


    /**
     * @see ILoggerFactory#getLogger(String)
     */
     Logger getLogger(String name);
}
