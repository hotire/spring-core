# Aware

https://blog.naver.com/gngh0101/221691289433

## BeanFactoryAware

DefaultListableBeanFactory 에 의해 initializeBean 에서 

invokeAwareMethods 호출하여 aware를 주입해준다.

### AbstractAutowireCapableBeanFactory 

- initializeBean
    - invokeAwareMethods 
        - BeanFactoryAware
    - applyBeanPostProcessorsBeforeInitialization   
        - ApplicationContextAwareProcessor : ApplicationContextAware
    - invokeInitMethods
        
     
    
