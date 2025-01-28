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

1. interceptor 설정
2. setResultHandler 설정

~~~java
	deferredResult.setResultHandler(result -> {
				result = interceptorChain.applyPostProcess(this.asyncWebRequest, deferredResult, result);
				setConcurrentResultAndDispatch(result);
			});
~~~

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

- org.springframework.web.context.request.async.DeferredResult#getInterceptor()

다시 WebAsyncManager.setConcurrentResultAndDispatch로 이어짐