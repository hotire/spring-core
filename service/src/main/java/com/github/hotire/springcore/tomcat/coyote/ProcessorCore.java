package com.github.hotire.springcore.tomcat.coyote;

import org.apache.coyote.Processor;
import org.apache.coyote.AbstractProcessor;

/**
 * @see Processor;
 */
public interface ProcessorCore {

    /**
     * @see Processor#timeoutAsync(long)
     * @see AbstractProcessor#timeoutAsync(long) 
     */
    void timeoutAsync(long now);
}
