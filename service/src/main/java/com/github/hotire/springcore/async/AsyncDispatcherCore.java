package com.github.hotire.springcore.async;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.catalina.AsyncDispatcher;

/**
 * @see AsyncDispatcher
 */
public interface AsyncDispatcherCore {

    /**
     * @see AsyncDispatcher#dispatch(ServletRequest, ServletResponse)
     */
    void dispatch(ServletRequest request, ServletResponse response)
        throws ServletException, IOException;
}
