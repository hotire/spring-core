# BeanPostProcessor

## AbstractApplicationContext

1. refresh() -> registerBeanPostProcessors(beanFactory) 호출 

2. registerBeanPostProcessors(beanFactory) -> PostProcessorRegistrationDelegate 처리 위윔

3. initializeBean

## PostProcessorRegistrationDelegate
PostProcessorRegistrationDelegate.registerBeanPostProcessors(beanFactory, this);

## AbstractAutowireCapableBeanFactory

initializeBean(String beanName, Object bean, @Nullable RootBeanDefinition mbd)

해당 메서드 안에서 postProcessBeforeInitialization / postProcessAfterInitialization

두개가 동작함. 

 

