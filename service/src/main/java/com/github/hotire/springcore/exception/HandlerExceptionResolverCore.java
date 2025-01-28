package com.github.hotire.springcore.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @see org.springframework.web.servlet.HandlerExceptionResolver
 * @see org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver
 */
public class HandlerExceptionResolverCore {

    /**
     * @see org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver#doResolveHandlerMethodException(HttpServletRequest, HttpServletResponse, HandlerMethod, Exception)
     */
    protected ModelAndView doResolveHandlerMethodException(HttpServletRequest request,
                                                           HttpServletResponse response, HandlerMethod handlerMethod, Exception exception) {

        return null;
    }
}
