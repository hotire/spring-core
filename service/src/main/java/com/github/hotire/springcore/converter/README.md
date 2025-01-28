# Converter

org.springframework.core.convert.converter.Converter

WebMvcAutoConfiguration AutoConfig에 의해서 

ApplicationConversionService.class addBeans 호출하여 web 영역으로 converter가 등록된다.

~~~java
public static void addBeans(FormatterRegistry registry, ListableBeanFactory beanFactory) {
		Set<Object> beans = new LinkedHashSet<>();
		beans.addAll(beanFactory.getBeansOfType(GenericConverter.class).values());
		beans.addAll(beanFactory.getBeansOfType(Converter.class).values());
		beans.addAll(beanFactory.getBeansOfType(Printer.class).values());
		beans.addAll(beanFactory.getBeansOfType(Parser.class).values());
		for (Object bean : beans) {
			if (bean instanceof GenericConverter) {
				registry.addConverter((GenericConverter) bean);
			}
			else if (bean instanceof Converter) {
				registry.addConverter((Converter<?, ?>) bean);
			}
			else if (bean instanceof Formatter) {
				registry.addFormatter((Formatter<?>) bean);
			}
			else if (bean instanceof Printer) {
				registry.addPrinter((Printer<?>) bean);
			}
			else if (bean instanceof Parser) {
				registry.addParser((Parser<?>) bean);
			}
		}
	}
~~~


## Auto-configured Spring MVC Tests

To test whether Spring MVC controllers are working as expected, use the @WebMvcTest annotation. 
@WebMvcTest auto-configures the Spring MVC infrastructure and limits scanned beans to @Controller, 
@ControllerAdvice, @JsonComponent, Converter, GenericConverter, Filter, HandlerInterceptor, WebMvcConfigurer, and HandlerMethodArgumentResolver.
 Regular @Component and @ConfigurationProperties beans are not scanned when the @WebMvcTest annotation is used. @EnableConfigurationProperties can be used to include @ConfigurationProperties beans.

https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-testing-spring-boot-applications-testing-autoconfigured-mvc-tests


### WebMvcTypeExcludeFilter

~~~java
Set<Class<?>> includes = new LinkedHashSet<>();
		includes.add(ControllerAdvice.class);
		includes.add(JsonComponent.class);
		includes.add(WebMvcConfigurer.class);
		includes.add(WebMvcRegistrations.class);
		includes.add(jakarta.servlet.Filter.class);
		includes.add(FilterRegistrationBean.class);
		includes.add(DelegatingFilterProxyRegistrationBean.class);
		includes.add(HandlerMethodArgumentResolver.class);
		includes.add(HttpMessageConverter.class);
		includes.add(ErrorAttributes.class);
		includes.add(Converter.class);
		includes.add(GenericConverter.class);
		includes.add(HandlerInterceptor.class);
~~~


