package com.github.hotire.springcore.aop.proxy;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.Interceptor;

/**
 * @see Advice
 */
public class CustomAdvice implements Advice {

    /**
     * @see org.aopalliance.intercept.Interceptor
     */
    public static class CustomInterceptor implements Interceptor {
    }

}
