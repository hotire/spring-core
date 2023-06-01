package com.github.hotire.springcore.tomcat.coyote;

import org.apache.coyote.AbstractProtocol;

/**
 * @see AbstractProtocol
 */
public class AbstractProtocolCore {

    /**
     * @see AbstractProtocol#getMaxThreads() 
     */
    public int getMaxThreads() { return 0; }

    /**
     * @see AbstractProtocol#setMaxThreads(int) 
     */
    public void setMaxThreads(int maxThreads) {
    }

    /**
     * @see AbstractProtocol#getMinSpareThreads() 
     */
    public int getMinSpareThreads() { return 0; }

    /**
     * @see AbstractProtocol#setMinSpareThreads(int) 
     */
    public void setMinSpareThreads(int minSpareThreads) {
    }
}
