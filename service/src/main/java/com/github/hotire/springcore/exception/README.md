# Exception 

### Spring DispatcherServlet의 내부 속으로 - 5 고급편(예외 처리 - @ControllerAdvice  동작 원리)

- https://blog.naver.com/gngh0101/221738449583

### ExceptionHandlerExceptionResolver


- initExceptionHandlerAdviceCache

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

- ExceptionHandlerMethodResolver

~~~java
public ExceptionHandlerMethodResolver(Class<?> handlerType) {
		for (Method method : MethodIntrospector.selectMethods(handlerType, EXCEPTION_HANDLER_METHODS)) {
			for (Class<? extends Throwable> exceptionType : detectExceptionMappings(method)) {
				addExceptionMapping(exceptionType, method);
			}
		}
	}
~~~

: EXCEPTION_HANDLER_METHODS 
~~~java
public static final MethodFilter EXCEPTION_HANDLER_METHODS = method ->
			AnnotatedElementUtils.hasAnnotation(method, ExceptionHandler.class);
~~~


ExceptionHandlerMethodResolver

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

### BasicErrorController

- ErrorMvcAutoConfiguration.basicErrorController

### DefaultErrorAttributes extends ErrorAttributes

- ErrorMvcAutoConfiguration.errorAttributes




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

### ErrorPageRegistry

### AbstractConfigurableWebServerFactory

~~~
private Set<ErrorPage> errorPages = new LinkedHashSet<>();
~~~

### AbstractServletWebServerFactory

### TomcatServletWebServerFactory


## Error Request 과정 

### CoyoteAdapter

- service

### StandardEngineValve

- invoke

### ErrorReportValve

- invoke

### StandardHostValve

- invoke

custom method 

~~~java 
RequestDispatcher rd =
                servletContext.getRequestDispatcher(errorPage.getLocation());
rd.forward(request.getRequest(), response.getResponse());
~~~


### AuthenticatorBase

- invoke

### StandardContextValve

- invoke

### StandardWrapperValve

~~~java
 @Override
 public final void invoke(Request request, Response response) {

try {
....

}  catch (ServletException e) {
              Throwable rootCause = StandardWrapper.getRootCause(e);
              if (!(rootCause instanceof ClientAbortException)) {
                  container.getLogger().error(sm.getString(
                          "standardWrapper.serviceExceptionRoot",
                          wrapper.getName(), context.getName(), e.getMessage()),
                          rootCause);
              }
              throwable = e;
              exception(request, response, e);
          }

}
~~~


## 404

### HandlerMapping

- SimpleUrlHandlerMapping

: /**

-> WebMvcConfigurationSupport.resourceHandlerMapping에 의해 등록된다. 

### HandlerAdapter

- HttpRequestHandlerAdapter

### ResourceHttpRequestHandler

~~~java
	Resource resource = getResource(request);
		if (resource == null) {
			logger.debug("Resource not found");
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
~~~


### org.apache.catalina.connector.Response

~~~java
 @Override
    public void sendError(int status, String message) throws IOException {

        if (isCommitted()) {
            throw new IllegalStateException
                (sm.getString("coyoteResponse.sendError.ise"));
        }

        // Ignore any call from an included servlet
        if (included) {
            return;
        }

        setError();

        getCoyoteResponse().setStatus(status);
        getCoyoteResponse().setMessage(message);

        // Clear any data content that has been buffered
        resetBuffer();

        // Cause the response to be finished (from the application perspective)
        setSuspended(true);
    }
~~~

~~~java
 public boolean setError() {
        return errorState.compareAndSet(0, 1);
    }
~~~
