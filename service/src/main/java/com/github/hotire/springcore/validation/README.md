# Validator

### ValidationAutoConfiguration

- 1.5 이후 Auto-Config 

spring boot 1.5 이후부터 ValidationAutoConfig, LocalValidatorFacoryBean Bean을 통해 Bean으로 등록된다.
HandlerMethodArgumentResolver 구현체 ModelAttributeMethodProcessor에 의해 WebDataBinder 를 찾는다. 

WebDataBinder 안에는 validator LocalValidatorFacoryBean 들어있다.  

## LocalValidatorFactoryBean

