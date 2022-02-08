# Properties



## Application properties, yml

### Boot Run 

### prepareEnvironment
~~~java
	listeners.environmentPrepared(bootstrapContext, environment);
~~~
### SpringApplicationRunListeners

~~~java
void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
		doWithListeners("spring.boot.application.environment-prepared",
				(listener) -> listener.environmentPrepared(bootstrapContext, environment));
	}
~~~

### EnvironmentPostProcessorApplicationListener

~~~java
@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ApplicationEnvironmentPreparedEvent) {
			onApplicationEnvironmentPreparedEvent((ApplicationEnvironmentPreparedEvent) event);
		}
		if (event instanceof ApplicationPreparedEvent) {
			onApplicationPreparedEvent();
		}
		if (event instanceof ApplicationFailedEvent) {
			onApplicationFailedEvent();
		}
	}
~~~

- onApplicationEnvironmentPreparedEvent 처리 

### ConfigDataEnvironmentPostProcessor : EnvironmentPostProcessor

~~~java
getConfigDataEnvironment(environment, resourceLoader, additionalProfiles).processAndApply();
~~~

- getConfigDataEnvironment() 을 통해 ConfigDataEnvironment 얻어온다.  이후 processAndApply 실행

### ConfigDataEnvironment

~~~java
this.loaders = new ConfigDataLoaders(logFactory, bootstrapContext);
~~~

- ConfigDataEnvironment 내부 필드 loaders에 사용할 loaders가 설정된다. 

이중 StandardConfigDataLoader 존재한다. 

- withProcessedImports

- resolveAndLoad

- resolve 

해당 과정중 StandardConfigDataLocationResolver 가져온다. 

- load

이떄 loaders가 load 한다. 

### ConfigDataLoaders

- load

### StandardConfigDataLoader : ConfigDataLoader

- load

### StandardConfigDataLocationResolver

~~~java
	this.propertySourceLoaders = SpringFactoriesLoader.loadFactories(PropertySourceLoader.class,
				getClass().getClassLoader());
~~~

- 생성할떄 PropertySourceLoader 구현체를 전부 가져온다. 

~~~java
	private String[] getConfigNames(Binder binder) {
		String[] configNames = binder.bind(CONFIG_NAME_PROPERTY, String[].class).orElse(DEFAULT_CONFIG_NAMES);
		for (String configName : configNames) {
			validateConfigName(configName);
		}
		return configNames;
	}
~~~
-  DEFAULT_CONFIG_NAMES : application

### YamlPropertySourceLoader : PropertySourceLoader

- load 



## References
- https://blog.naver.com/gngh0101/222234252938