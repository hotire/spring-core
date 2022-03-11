# Auto-Config


ConfigurationClassParser 까지 ... (https://blog.naver.com/gngh0101/221547017730)

- AbstractApplicationContext.refresh

- AbstractApplicationContext.invokeBeanFactoryPostProcessors

- PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());

- ConfigurationClassParser.processImports

~~~
	if (selector instanceof DeferredImportSelector) {
							this.deferredImportSelectorHandler.handle(configClass, (DeferredImportSelector) selector);
						}
~~~

DeferredImportSelector 따로 처리한다. 


- parse 가 끝난 후 DeferredImportSelector에 쌓아둔 작업 처리 


## AutoConfigurationPackage

- @Import(AutoConfigurationPackages.Registrar.class)

### Registrar

~~~java
	public static void register(BeanDefinitionRegistry registry, String... packageNames) {
		if (registry.containsBeanDefinition(BEAN)) {
			BasePackagesBeanDefinition beanDefinition = (BasePackagesBeanDefinition) registry.getBeanDefinition(BEAN);
			beanDefinition.addBasePackages(packageNames);
		}
		else {
			registry.registerBeanDefinition(BEAN, new BasePackagesBeanDefinition(packageNames));
		}
	}
~~~

### PackageImports


### BasePackages

~~~java
static final class BasePackagesBeanDefinition extends GenericBeanDefinition {

		private final Set<String> basePackages = new LinkedHashSet<>();

		BasePackagesBeanDefinition(String... basePackages) {
			setBeanClass(BasePackages.class);
			setRole(BeanDefinition.ROLE_INFRASTRUCTURE);
			addBasePackages(basePackages);
		}

		@Override
		public Supplier<?> getInstanceSupplier() {
			return () -> new BasePackages(StringUtils.toStringArray(this.basePackages));
		}

		private void addBasePackages(String[] additionalBasePackages) {
			this.basePackages.addAll(Arrays.asList(additionalBasePackages));
		}

	}
~~~

## @SpringBootApplication

-https://blog.naver.com/gngh0101/221754735617

### @EnableAutoConfiguration

### AutoConfigurationImportSelector

~~~java
protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
		List<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),
				getBeanClassLoader());
		Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you "
				+ "are using a custom packaging, make sure that file is correct.");
		return configurations;
	}
~~~

AutoConfigurationImportSelector를 통해서 configurations 전부 가져온다. 


### WebMvcAutoConfiguration
~~~java
@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
~~~

### EnableWebMvcConfiguration extends DelegatingWebMvcConfiguration








