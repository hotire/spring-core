# Scope

Spring Factory 에서 정의한 Scope은 singleton / prototype 두개 뿐이다.

org.springframework.beans.factory.config.ConfigurableBeanFactory

다만 custom이 가능하다.

ConfigurableBeanFactory.registerScope(String scopeName, Scope scope);


## Web

ServletWebServerApplicationContext.postProcessBeanFactory()

-> registerWebApplicationScopes() -> WebApplicationContextUtils.registerWebApplicationScopes()

WebApplicationContext RequestScope / SessionScope / AppScope

MVC의 경우  3가지를 추가적으로 등록하게 된다.


