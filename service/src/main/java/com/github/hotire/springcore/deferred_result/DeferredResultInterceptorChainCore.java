package com.github.hotire.springcore.deferred_result;


import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @see org.springframework.web.context.request.async.DeferredResultInterceptorChain;
 */
public class DeferredResultInterceptorChainCore {


    /**
     * @see org.springframework.web.context.request.async.DeferredResultInterceptorChain#triggerAfterTimeout(NativeWebRequest, DeferredResult)
     */
    public void triggerAfterTimeout(NativeWebRequest request, DeferredResult<?> deferredResult) throws Exception {

    }
}
