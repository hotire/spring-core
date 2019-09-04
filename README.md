# spring-core
study

너무 많은 내용이라, 블로그에 정리함

## ApplicationContext

### Bean register 등록 원리 -1
https://blog.naver.com/gngh0101/221576302088

### Bean register 등록 원리 -2
https://blog.naver.com/gngh0101/221590684880

### BeanFactory vs ApplicationContext 
https://blog.naver.com/gngh0101/221639046641

### ClassPathXmlApplicationContext

- 고전적인 xml를 이용한 빈 설정 방법

### AnnotationConfigApplicationContext

- @Configuration 을 이용한 빈 설정 방법


## Bean Scope

- Singleton

- Prototype

프로토타입 빈이 싱글톤 빈을 참조할 경우 문제가 없다.

하지만 싱글톤 빈이 프로토 타입 빈을 참조하면 

프로토타입 빈이 초기 래퍼런스 값을 변경하지 않는다. 

-> scoped-proxy, Object-Provider






## DispatcherServlet

### 초기화와 기본전략
- https://blog.naver.com/gngh0101/221511448131

### HandlerMapping의 이해
- https://blog.naver.com/gngh0101/221513567499

### HandlerAdapter의 이해 
- https://blog.naver.com/gngh0101/221515450102

### @ResponseBody, @RestController 동작 원리
- https://blog.naver.com/gngh0101/221516352327

```
```

## AOP(Aspect-Oriented Programming)

### AOP의 이해
- https://blog.naver.com/gngh0101/221518490172

### Dynamic Proxy 동작 원리
- https://blog.naver.com/gngh0101/221521927798

### cglib
- https://blog.naver.com/gngh0101/221527082367

```
```
## Configuration 

### Configuration Component 차이점 
- https://blog.naver.com/gngh0101/221535845386

### Configuration CGLIB 동작 원리
- https://blog.naver.com/gngh0101/221536672573

```
```
## Enable Annotation

### Import(Configuration, ImportSelector, ImportBeanDefinitionRegistrar)의 이해

- https://blog.naver.com/gngh0101/221542525164

### Import(Configuration, ImportSelector, ImportBeanDefinitionRegistrar)의 동작 원리

- https://blog.naver.com/gngh0101/221547017730


```
```

## SpEL 
Spring Expression Language의 줄인 말로 런타임 시점에 object graph 를

조회, 조작하는 강력한 언어이다. 

- object graph : 객체들의 연관 관계, 정보를 보여주는 그래프




~~~
~~~


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




