# Init

- https://blog.naver.com/gngh0101/221691289433

## AbstractAutowireCapableBeanFactory 

initializeBean 에서 init 메서드들이 실행된다.

- applyBeanPostProcessorsBeforeInitialization

- invokeInitMethods
    - InitializingBean (afterPropertiesSet)
    - invokeCustomInitMethod (@Bean(initMethod = "init"))
    
- applyBeanPostProcessorsBeforeInitialization
    - PostConstruct, CommonAnnotationBeanPostProcessor : InitDestroyAnnotationBeanPostProcessor에 의해 invokeInitMethods 호출한다. 
   
