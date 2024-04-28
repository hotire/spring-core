package com.github.hotire.springcore.exception;

import static org.springframework.web.method.annotation.ExceptionHandlerMethodResolver.EXCEPTION_HANDLER_METHODS;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.MethodIntrospector;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;

/**
 * @see ExceptionHandlerMethodResolver
 */
public class ExceptionHandlerMethodResolverCore {

    /**
     * @see ExceptionHandlerMethodResolver#mappedMethods
     */
    private final Map<Class<? extends Throwable>, Method> mappedMethods = new HashMap<>(16);

    public ExceptionHandlerMethodResolverCore(Class<?> handlerType) {
        for (Method method : MethodIntrospector.selectMethods(handlerType, EXCEPTION_HANDLER_METHODS)) {
            for (Class<? extends Throwable> exceptionType : detectExceptionMappings(method)) {
                addExceptionMapping(exceptionType, method);
            }
        }
    }

    /**
     * @see ExceptionHandlerMethodResolver#detectExceptionMappings(Method) 
     */
    private List<Class<? extends Throwable>> detectExceptionMappings(Method method) {
        return new ArrayList<>();
    }

    /**
     * @see ExceptionHandlerMethodResolver#addExceptionMapping(Class, Method)
     */
    private void addExceptionMapping(Class<? extends Throwable> exceptionType, Method method) {
        Method oldMethod = this.mappedMethods.put(exceptionType, method);
        if (oldMethod != null && !oldMethod.equals(method)) {
            throw new IllegalStateException("Ambiguous @ExceptionHandler method mapped for [" +
                exceptionType + "]: {" + oldMethod + ", " + method + "}");
        }
    }

}
