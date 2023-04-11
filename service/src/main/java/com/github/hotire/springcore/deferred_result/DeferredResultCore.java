package com.github.hotire.springcore.deferred_result;

import java.util.function.Consumer;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResult.DeferredResultHandler;

/**
 * @see DeferredResult
 */
public class DeferredResultCore {

    /**
     * @see DeferredResult#onError(Consumer)
     */
    public void onError(Consumer<Throwable> callback) {
      
    }

    /**
     * @see DeferredResult#setErrorResult(Object)
     */
    public boolean setErrorResult(Object result) {
        return true;
    }

    /**
     * @see DeferredResult#setResultHandler(DeferredResultHandler)
     */
    public final void setResultHandler(DeferredResultHandler resultHandler) {
        
    }
}
