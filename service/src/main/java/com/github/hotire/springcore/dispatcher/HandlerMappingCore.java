package com.github.hotire.springcore.dispatcher;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.HandlerExecutionChain;

/**
 * @see org.springframework.web.servlet.HandlerMapping
 * @see org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping 
 */
public class HandlerMappingCore {

    /**
     * @see org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping#getHandler(HttpServletRequest) 
     */
    public HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        return new HandlerExecutionChain(null);
    }
}
