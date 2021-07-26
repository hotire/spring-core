# spring-core

![logo](/doc/img/logo.jpg)

study

너무 많은 내용이라, 블로그에 정리함

core reference : https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#spring-core

## ApplicationContext

Spring IoC Container and Beans

![context](/doc/img/context.png)

### Bean register 등록 원리 -1
https://blog.naver.com/gngh0101/221576302088

### Bean register 등록 원리 -2
https://blog.naver.com/gngh0101/221590684880

### BeanFactory vs ApplicationContext 
https://blog.naver.com/gngh0101/221639046641

### Dependency Injection Constructor 생성자 주입 원리
https://blog.naver.com/gngh0101/221683567520

### Dependency Injection Autowired Filed Setter 주입 원리
https://blog.naver.com/gngh0101/221690000028

### InitializeBean (@PostConstruct / InitializingBean / CustomInitMethod ... )동작 원리와 순서 
https://blog.naver.com/gngh0101/221691289433

### FactoryBean 동작 원리

https://blog.naver.com/gngh0101/222027480358

### Event Publisher 동작 원리 
https://blog.naver.com/gngh0101/222020512119

### EventListener Bean 등록 과정
https://blog.naver.com/gngh0101/222022197174

### EventListener Event dispatch 동작 원리 

https://blog.naver.com/gngh0101/222040857815

### Event Custom ApplicationEventMulticaster

https://blog.naver.com/gngh0101/222047805469

### ClassPathXmlApplicationContext

- 고전적인 xml를 이용한 빈 설정 방법

### AnnotationConfigApplicationContext

- @Configuration 을 이용한 빈 설정 방법

### Application Context LifeCycle with Event
https://blog.naver.com/gngh0101/222363176425

### Bean Scope

https://blog.naver.com/gngh0101/222344239921

- Singleton

- Prototype

프로토타입 빈이 싱글톤 빈을 참조할 경우 문제가 없다.

하지만 싱글톤 빈이 프로토 타입 빈을 참조하면 

프로토타입 빈이 초기 래퍼런스 값을 변경하지 않는다. 

-> scoped-proxy, Object-Provider

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


## AutoConfig

### Stater 
https://blog.naver.com/gngh0101/222044744634

- reference 
https://www.baeldung.com/spring-boot-custom-starter


## Profile 

2.4.0 이후부터 spring.profiles 이 아닌 spring.config.activate.on-profile 사용함 

- 2.4.0 Migration Guide : https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-Config-Data-Migration-Guide


## Boot Run

### 1. WebApplicationType / SpringFactoriesLoader

https://blog.naver.com/gngh0101/222195371984

### 2. bootstrapper, SpringApplicationRunListener

https://blog.naver.com/gngh0101/222202365575

### 3. ConfigurableEnvironment

https://blog.naver.com/gngh0101/222208890915

### 4. Application.yml / properties load
  
https://blog.naver.com/gngh0101/222234252938

### 5. SpringApplicationRunListener

https://blog.naver.com/gngh0101/222445524716



## MVC

### @EnableWebMvc, AutoConfiguration 원리

- https://blog.naver.com/gngh0101/221754735617

## DispatcherServlet

### 초기화와 기본전략
- https://blog.naver.com/gngh0101/221511448131

### HandlerMapping의 이해
- https://blog.naver.com/gngh0101/221513567499

### HandlerAdapter의 이해 
- https://blog.naver.com/gngh0101/221515450102

### @ResponseBody, @RestController 동작 원리
- https://blog.naver.com/gngh0101/221516352327

### 예외 처리 - @ControllerAdvice  동작 원리

- https://blog.naver.com/gngh0101/221738449583

```
```

## WebFlux

https://github.com/hotire/spring-boot-webflux

## 기타 

### Enable Async 동작 원리 
https://blog.naver.com/gngh0101/222073112894

### Optimizing Spring Integration Tests

https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#testcontext-ctx-management-caching
https://www.baeldung.com/spring-tests

### Converter

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


- Auto-configured Spring MVC Tests

To test whether Spring MVC controllers are working as expected, use the @WebMvcTest annotation. 
@WebMvcTest auto-configures the Spring MVC infrastructure and limits scanned beans to @Controller, 
@ControllerAdvice, @JsonComponent, Converter, GenericConverter, Filter, HandlerInterceptor, WebMvcConfigurer, and HandlerMethodArgumentResolver.
 Regular @Component and @ConfigurationProperties beans are not scanned when the @WebMvcTest annotation is used. @EnableConfigurationProperties can be used to include @ConfigurationProperties beans.

https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-testing-spring-boot-applications-testing-autoconfigured-mvc-tests

