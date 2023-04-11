# DeferredResult

## Internal Core

### DeferredResultMethodReturnValueHandler

- handleReturnValue 
~~~
WebAsyncUtils.getAsyncManager(webRequest).startDeferredResultProcessing(result, mavContainer);
~~~

### WebAsyncUtils

- getAsyncManager

### WebAsyncManager

- startDeferredResultProcessing

### DeferredResult

- setResultHandler

### DeferredResultInterceptorChain

### DeferredResult.DeferredResultHandler

- handleResult

~~~java
deferredResult.setResultHandler(result -> {
				result = interceptorChain.applyPostProcess(this.asyncWebRequest, deferredResult, result);
				setConcurrentResultAndDispatch(result);
			});
~~~

### DeferredResultInterceptorChain

- applyPostProcess

### DeferredResultProcessingInterceptor

