package com.github.hotire.springcore.boot.run;

import org.springframework.boot.WebApplicationType;

/**
 * @see org.springframework.boot.WebApplicationType
 */
public class WebApplicationTypeCore {

    /**
     * @see WebApplicationType#deduceFromClasspath()
     */
    static WebApplicationType deduceFromClasspath() {
        return WebApplicationType.SERVLET;
    }

}
