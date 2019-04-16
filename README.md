# spring-core
study

## DispatcherServlet

### 초기화와 기본전략
https://blog.naver.com/gngh0101/221511448131

### HandlerMapping의 이해
https://blog.naver.com/gngh0101/221513567499

### HandlerAdapter의 이해 + @ResponseBody 동작원리
https://blog.naver.com/gngh0101/221515450102




### 초기화(initStrategies)
DispatcherSevlet은 initStrategies를 통해 handlerMapping, handlerAdapter 등 초기화한다.

```
	protected void initStrategies(ApplicationContext context) {
		initMultipartResolver(context);
		initLocaleResolver(context);
		initThemeResolver(context);
		initHandlerMappings(context);
		initHandlerAdapters(context);
		initHandlerExceptionResolvers(context);
		initRequestToViewNameTranslator(context);
		initViewResolvers(context);
		initFlashMapManager(context);
	}
	
```

- 모두 전략패턴(디자인패턴)을 통해 구현되었다. 

```
private void initHandlerMappings(ApplicationContext context) {
		this.handlerMappings = null;

		if (this.detectAllHandlerMappings) {
			// Find all HandlerMappings in the ApplicationContext, including ancestor contexts.
			Map<String, HandlerMapping> matchingBeans =
					BeanFactoryUtils.beansOfTypeIncludingAncestors(context, HandlerMapping.class, true, false);
			if (!matchingBeans.isEmpty()) {
				this.handlerMappings = new ArrayList<>(matchingBeans.values());
				// We keep HandlerMappings in sorted order.
				AnnotationAwareOrderComparator.sort(this.handlerMappings);
			}
		}
```
Spring Boot 2.1.0 기준 5개나 있다. 

하지만 만약 구현한 handlerMappings가 없다면, 기본전략을 택한다. 


```
	if (this.handlerMappings == null) {
			this.handlerMappings = getDefaultStrategies(context, HandlerMapping.class);
			if (logger.isTraceEnabled()) {
				logger.trace("No HandlerMappings declared for servlet '" + getServletName() +
						"': using default strategies from DispatcherServlet.properties");
			}
		}
```
### 기본전략(DefaultStrategies)

handlerMappings가 없으면 getDefaultStategies 메서드를 호출한다. 

```
protected <T> List<T> getDefaultStrategies(ApplicationContext context, Class<T> strategyInterface) {
		String key = strategyInterface.getName();
		String value = defaultStrategies.getProperty(key);

private static final Properties defaultStrategies;

```
defaultSrategies의 초기화 시점은 static이다. 


```
static {
		// Load default strategy implementations from properties file.
		// This is currently strictly internal and not meant to be customized
		// by application developers.
		try {
			ClassPathResource resource = new ClassPathResource(DEFAULT_STRATEGIES_PATH, DispatcherServlet.class);
			defaultStrategies = PropertiesLoaderUtils.loadProperties(resource);
		}
		catch (IOException ex) {
			throw new IllegalStateException("Could not load '" + DEFAULT_STRATEGIES_PATH + "': " + ex.getMessage());
		}
	}

```

기본전략의 ClassPath를 확인해보자. 

```
private static final String DEFAULT_STRATEGIES_PATH = "DispatcherServlet.properties";

```

DispatcherServlet.properties의 기본전략은 BeanNameUrlHandlerMapping과 RequestMappingHandlerMapping이다. 


```
org.springframework.web.servlet.HandlerMapping=org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping,\
	org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping

```




