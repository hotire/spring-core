package com.github.hotire.springcore.async;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
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
