# Run 

## Boot Run

- summary
0. bootstrapContext 생성, SpringApplicationRunListenersCore 생성    
1. prepareEnvironment : webApplicationType 에 따른 Environment 생성, ApplicationEnvironmentPreparedEvent 발생시켜 application.yml load 
2. webApplicationType에 따른 ApplicationContext 생성 
3. prepareContext : Environment과 ApplicationContext 연결, ApplicationContextInitializer 실행, ApplicationContextInitializedEvent 발생 
4. refreshContext : 
 

### 1. WebApplicationType / SpringFactoriesLoader

https://blog.naver.com/gngh0101/222195371984

### 2. bootstrapper, SpringApplicationRunListener

https://blog.naver.com/gngh0101/222202365575

### 3. ConfigurableEnvironment

https://blog.naver.com/gngh0101/222208890915

### 4. Application.yml / properties load
  
https://blog.naver.com/gngh0101/222234252938

~~~java
listeners.environmentPrepared(bootstrapContext, environment);
~~~
- prepareEnvironment


environmentPrepared 구현체 중 EnvironmentPostProcessorApplicationListener 가 존재하고

EnvironmentPostProcessorApplicationListener 에 의해 EnvironmentPostProcessor





### 5. SpringApplicationRunListener

https://blog.naver.com/gngh0101/222445524716

### 6. ConfigDataEnvironment.processAndApply

~~~java
ConfigDataActivationContext activationContext = createActivationContext(
				contributors.getBinder(null, BinderOption.FAIL_ON_BIND_TO_INACTIVE_SOURCE));
~~~
