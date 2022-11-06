# Argument

## HandlerMethodArgumentResolverComposite

- RequestMappingHandlerAdapter
- ServletInvocableHandlerMethod
- InvocableHandlerMethod

getMethodArgumentValues -> HandlerMethodArgumentResolverComposite

## HandlerMethodArgumentResolver 

### ModelAttributeMethodProcessor



## Register

### WebMvcConfigurationSupport

- requestMappingHandlerAdapter
- getArgumentResolvers
- addArgumentResolvers

### DelegatingWebMvcConfiguration

- addArgumentResolvers

### RequestMappingHandlerAdapter

- afterPropertiesSet
- getDefaultArgumentResolvers
- getCustomArgumentResolvers