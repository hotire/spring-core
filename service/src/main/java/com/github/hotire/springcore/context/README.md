# ApplicationContext

## refresh

java-file, xml 등의 configuration을 load 하거나 refresh 하는 메서드이다.

## Summary

### postProcessBeanFactory

beanFactory의 post 작업으로 

AnnotationConfigServletWebServerApplicationContext은 오버라이딩하여 
package scan이 이루어진다.
추가적으로 registerWebApplicationScopes() web전용 bean scopre도 등록된다.

### invokeBeanFactoryPostProcessors

등록된 BeanFactoryPostProcessor 을 인스턴스화하고 모두 호출한다.
BeanFactoryPostProcessor 확장한 BeanDefinitionRegistryPostProcessor도 추가적으로 호출된다.

BeanDefinitionRegistryPostProcessor 대표적으로 ConfigurationClassPostProcessor

### registerBeanPostProcessors

모든 BeanPostProcessor Bean을 인스턴스화하고 등록합니다.

### initApplicationEventMulticaster

applicationEventMulticaster를 초기화한다. (SimpleApplicationEventMulticaster) 

### onRefresh

webServer을 생성한다.

### registerListeners

EventListeners를 등록한다.

### finishBeanFactoryInitialization

BeanDefinition singleTon bean에 대해서 한번씩 호출하여 bean으로 생성한다. 





