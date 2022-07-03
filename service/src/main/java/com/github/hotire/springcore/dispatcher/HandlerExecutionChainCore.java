package com.github.hotire.springcore.dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExecutionChain;

/**
 * @see HandlerExecutionChain
 */
public class HandlerExecutionChainCore {

    /**
     * @see HandlerExecutionChain#applyPreHandle(HttpServletRequest, HttpServletResponse)
     */
    boolean applyPreHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return false;
    }
}
