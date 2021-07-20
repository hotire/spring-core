# Spring ApplicationContext Life-Cycle

## Life-Cycle

org.springframework.context.Lifecycle

~~~java
public interface Lifecycle {

	void start();
	
	void stop();

	boolean isRunning();

}
~~~

### LifecycleProcessor

Lifecycle 확장한 형태이다. 

org.springframework.context.LifecycleProcessor

~~~java
public interface LifecycleProcessor extends Lifecycle {
	void onRefresh();
	
	void onClose();
}
~~~~

- reference : https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-factory-lifecycle-processor


## Event

https://docs.spring.io/spring-framework/docs/3.0.x/spring-framework-reference/html/beans.html#context-functionality-events

org.springframework.context.event 패키지로

실제적으로 해당 이벤트를 통해 Spring Application의 Life-cycle을 알 수 있다. 

### ContextStartedEvent
Event raised when an ApplicationContext gets started.
### ContextStoppedEvent
Event raised when an ApplicationContext gets stopped.
### ContextClosedEvent
Event raised when an ApplicationContext gets closed.
### ContextRefreshedEvent
Event raised when an ApplicationContext gets initialized or refreshed.


### callRunners

ApplicationRunner / CommandLineRunner 의 경우 

SpringApplication.run 동작 과정 마지막 callRunners 실행 해당 구현체를 실행시킨다.


