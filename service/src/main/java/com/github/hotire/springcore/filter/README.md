# Filter

FilterRegistrationBean 생

ApplicationContext.refresh -> ServletWebServerApplicationContext.onRefresh -> createWebServer

getSelfInitializer 호출  ServletContextInitializerBeans에 의해서 호출된다. 


## OncePerRequestFilter

- https://jerry92k.tistory.com/70


### 일반적인 Jackson 호출 흐림
DispatcherServlet.doDispatch
-> RequestMappingHandlerAdapter.handle
-> RequestMappingHandlerAdapter.handleInternal
-> RequestMappingHandlerAdapter.invokeHandlerMethod
-> ServletInvocableHandlerMethod.invokeAndHandle
-> HandlerMethodReturnValueHandlerComposite.handleReturnValue
-> HttpEntityMethodProcessor.handleReturnValue
-> HttpEntityMethodProcessor.writeWithMessageConverters
-> MappingJackson2HttpMessageConverter.write
-> MappingJackson2HttpMessageConverter.writeInternal

### ContentCachingResponseWrapper
- FastByteArrayOutputStream 이라는 버퍼 객체를 가지고 캐싱
- ServletOutputStream을 상속한 ResponseServletOutputStream inner 클래스를 사용합니다. 
  - 메세지 컨버터에서 OutputStream으로 데이터를 생성할때, ResponseServletOutputStream를 이용하여 실제 클라이언트로 전달할 ResponseFacade의 OutputStream에 데이터를 쓰지 않고, FastByteArrayOutputStream에 데이터를 쓰게 합니다.
- getContentAsByteArray 메서드를 이용해 FastByteArrayOutputStream에 접근 가능하여 데이터를 로깅할 수 있습니다.
- copyBodyToResponse 메서드를 이용해 ContentCachingResponseWrapper이 상속하고 있는 ServletResponseWrapper의 response 내부에 OutputStream에 데이터를 복사해줍니다.
  - servlet container에서 HTTP 메세지를 만들때, ServletResponse 인터페이스의 getOutputStream() 호출하게 되는데,
  - 이때 구현체인 ServletResponseWrapper의 getOutputStream()이 참조되므로, 여기에서 사용되는 response 객체의 OutputStream에 데이터 복사