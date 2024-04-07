package com.github.hotire.springcore.exception;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.lang.Nullable;
import org.springframework.web.method.ControllerAdviceBean;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

/**
 * @see ExceptionHandlerExceptionResolver
 */
public class ExceptionHandlerExceptionResolverCore {
    private final Map<Class<?>, ExceptionHandlerMethodResolver> exceptionHandlerCache =
        new ConcurrentHashMap<>(64);

    private final Map<ControllerAdviceBean, ExceptionHandlerMethodResolver> exceptionHandlerAdviceCache =
        new LinkedHashMap<>();

    /**
     * @see ExceptionHandlerExceptionResolver#getExceptionHandlerMethod(HandlerMethod, Exception)
     * @param handlerMethod
     * @param exception
     * @return
     */
    protected ServletInvocableHandlerMethod getExceptionHandlerMethod(
        @Nullable HandlerMethod handlerMethod, Exception exception) {
        return null;
    }
}
