# Exception 

## MVC

### Spring DispatcherServlet의 내부 속으로 - 5 고급편(예외 처리 - @ControllerAdvice  동작 원리)

- https://blog.naver.com/gngh0101/221738449583

### ExceptionHandlerExceptionResolver

~~~java
	List<ControllerAdviceBean> adviceBeans = ControllerAdviceBean.findAnnotatedBeans(getApplicationContext());
		for (ControllerAdviceBean adviceBean : adviceBeans) {
			Class<?> beanType = adviceBean.getBeanType();
			if (beanType == null) {
				throw new IllegalStateException("Unresolvable type for ControllerAdviceBean: " + adviceBean);
			}
			ExceptionHandlerMethodResolver resolver = new ExceptionHandlerMethodResolver(beanType);
			if (resolver.hasExceptionMappings()) {
				this.exceptionHandlerAdviceCache.put(adviceBean, resolver);
			}
			if (ResponseBodyAdvice.class.isAssignableFrom(beanType)) {
				this.responseBodyAdvice.add(adviceBean);
			}
		}
~~~

### WebMvcConfigurationSupport

- WebMvcAutoConfiguration
~~~java
@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
~~~

WebMvcAutoConfiguration에 의해서 WebMvcConfigurationSupport를 상속받은 EnableWebMvcConfiguration를 config로 등록한다.

~~~java
protected ExceptionHandlerExceptionResolver createExceptionHandlerExceptionResolver() {
		return new ExceptionHandlerExceptionResolver();
	}
~~~

createExceptionHandlerExceptionResolver 의해 ExceptionHandlerExceptionResolver가 생성된다. 

~~~java
	@Bean
	public HandlerExceptionResolver handlerExceptionResolver(
			@Qualifier("mvcContentNegotiationManager") ContentNegotiationManager contentNegotiationManager) {
		List<HandlerExceptionResolver> exceptionResolvers = new ArrayList<>();
		configureHandlerExceptionResolvers(exceptionResolvers);
		if (exceptionResolvers.isEmpty()) {
			addDefaultHandlerExceptionResolvers(exceptionResolvers, contentNegotiationManager);
		}
		extendHandlerExceptionResolvers(exceptionResolvers);
		HandlerExceptionResolverComposite composite = new HandlerExceptionResolverComposite();
		composite.setOrder(0);
		composite.setExceptionResolvers(exceptionResolvers);
		return composite;
	}
~~~


### HandlerExceptionResolverComposite

WebMvcConfigurationSupport에 의해 HandlerExceptionResolverComposite이 빈으로 등록된다. 


### ErrorController

- https://supawer0728.github.io/2019/04/04/spring-error-handling/



### StandardHostValve

custom method 

~~~java 
RequestDispatcher rd =
                servletContext.getRequestDispatcher(errorPage.getLocation());
rd.forward(request.getRequest(), response.getResponse());
~~~



## Error Page

### ErrorMvcAutoConfiguration

### ErrorPageCustomizer

~~~java
        @Override
		public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
			ErrorPage errorPage = new ErrorPage(
					this.dispatcherServletPath.getRelativePath(this.properties.getError().getPath()));
			errorPageRegistry.addErrorPages(errorPage);
		}
~~~



