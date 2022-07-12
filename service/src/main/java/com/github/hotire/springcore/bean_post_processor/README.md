# BeanPostProcessor

BeanPostProcessor는 빈의 초기화(Initialization) 단계의 이전과 이후에 또 다른 부가적인 작업을 할 수 있게 해주는 인터페이스이다

## AbstractApplicationContext

1. refresh() -> registerBeanPostProcessors(beanFactory) 호출 

2. registerBeanPostProcessors(beanFactory) -> PostProcessorRegistrationDelegate 처리 위윔

3. initializeBean : AbstractAutowireCapableBeanFactory 호출 

## PostProcessorRegistrationDelegate
PostProcessorRegistrationDelegate.registerBeanPostProcessors(beanFactory, this);

## AbstractAutowireCapableBeanFactory

initializeBean(String beanName, Object bean, @Nullable RootBeanDefinition mbd)

해당 메서드 안에서 postProcessBeforeInitialization / postProcessAfterInitialization

두개가 동작함. 

 

