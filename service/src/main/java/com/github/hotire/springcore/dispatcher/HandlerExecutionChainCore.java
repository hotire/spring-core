package com.github.hotire.springcore.dispatcher;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
