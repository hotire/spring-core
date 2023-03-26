package com.github.hotire.springcore.async;

import java.util.concurrent.Callable;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncManager;

/**
 * @see WebAsyncManager
 */
public class WebAsyncManagerCore {

    /**
     * @see WebAsyncManager#startCallableProcessing(Callable, Object...)
     */
    public void startCallableProcessing(Callable<?> callable, Object... processingContext) throws Exception {
        
    }

    /**
     * @see WebAsyncManager#startDeferredResultProcessing(DeferredResult, Object...)
     */
    public void startDeferredResultProcessing(
        final DeferredResult<?> deferredResult, Object... processingContext) throws Exception {
        
    }

    /**
     * @see WebAsyncManager#setConcurrentResultAndDispatch(Object) 
     */
    private void setConcurrentResultAndDispatch(Object result) {
        
    }
}
