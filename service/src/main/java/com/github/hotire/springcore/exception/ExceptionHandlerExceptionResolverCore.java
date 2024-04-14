package com.github.hotire.springcore.exception;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.web.method.ControllerAdviceBean;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;

/**
 * @see ExceptionHandlerExceptionResolver
 */
@RequiredArgsConstructor
public class ExceptionHandlerExceptionResolverCore {

    /**
     * @see ExceptionHandlerExceptionResolver#exceptionHandlerCache
     */
    private final Map<Class<?>, ExceptionHandlerMethodResolver> exceptionHandlerCache =
        new ConcurrentHashMap<>(64);

    private final Map<ControllerAdviceBean, ExceptionHandlerMethodResolver> exceptionHandlerAdviceCache =
        new LinkedHashMap<>();

    private final ApplicationContext applicationContext;

    /**
     * @see ExceptionHandlerExceptionResolver#getExceptionHandlerMethod(HandlerMethod, Exception)
     * @param handlerMethod
     * @param exception
     * @return
     */
    protected ServletInvocableHandlerMethod getExceptionHandlerMethod(
        @Nullable HandlerMethod handlerMethod, Exception exception) {

        Class<?> handlerType = null;

        if (handlerMethod != null) {
            // Local exception handler methods on the controller class itself.
            // To be invoked through the proxy, even in case of an interface-based proxy.
            handlerType = handlerMethod.getBeanType();
            ExceptionHandlerMethodResolver resolver = this.exceptionHandlerCache.get(handlerType);
            if (resolver == null) {
                resolver = new ExceptionHandlerMethodResolver(handlerType);
                this.exceptionHandlerCache.put(handlerType, resolver);
            }
            Method method = resolver.resolveMethod(exception);
            if (method != null) {
                return new ServletInvocableHandlerMethod(handlerMethod.getBean(), method, this.applicationContext);
            }
            // For advice applicability check below (involving base packages, assignable types
            // and annotation presence), use target class instead of interface-based proxy.
            if (Proxy.isProxyClass(handlerType)) {
                handlerType = AopUtils.getTargetClass(handlerMethod.getBean());
            }
        }

        return null;
    }
}
