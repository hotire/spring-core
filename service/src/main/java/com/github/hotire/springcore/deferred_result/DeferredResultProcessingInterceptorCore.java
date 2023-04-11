package com.github.hotire.springcore.deferred_result;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;

/**
 * @see DeferredResultProcessingInterceptor
 * @see DeferredResult#getInterceptor()
 */
public class DeferredResultProcessingInterceptorCore {

    /**
     * @see DeferredResultProcessingInterceptor#postProcess(NativeWebRequest, DeferredResult, Object) 
     */
    public  <T> void postProcess(NativeWebRequest request, DeferredResult<T> deferredResult,
        Object concurrentResult) throws Exception {
    }

}
