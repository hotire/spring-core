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




