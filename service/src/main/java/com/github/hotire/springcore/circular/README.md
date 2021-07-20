# Circular

### Constructor && Autowired

AbstractAutowireCapableBeanFactory
~~~java
protected BeanWrapper createBeanInstance(String beanName, RootBeanDefinition mbd, @Nullable Object[] args) {
    ...
    ...
    autowireConstructor...
}
protected BeanWrapper autowireConstructor(
			String beanName, RootBeanDefinition mbd, @Nullable Constructor<?>[] ctors, @Nullable Object[] explicitArgs) {

    return new ConstructorResolver(this).autowireConstructor(beanName, mbd, ctors, explicitArgs);
}
~~~

Constructor 주입이 필요한 Bean이 먼저 생성될 경우, 생성자 주입에 필요한 Bean을 알아오는 작업을 한다.

ConstructorResolver
~~~java
public BeanWrapper autowireConstructor(String beanName, RootBeanDefinition mbd,
			@Nullable Constructor<?>[] chosenCtors, @Nullable Object[] explicitArgs) {
    
     createArgumentArray
}
~~~
~~~java
private ArgumentsHolder createArgumentArray(
			String beanName, RootBeanDefinition mbd, @Nullable ConstructorArgumentValues resolvedValues,
			BeanWrapper bw, Class<?>[] paramTypes, @Nullable String[] paramNames, Executable executable,
			boolean autowiring, boolean fallback) throws UnsatisfiedDependencyException {
    resolveAutowiredArgument...
}
~~~
~~~java
protected Object resolveAutowiredArgument(MethodParameter param, String beanName,
			@Nullable Set<String> autowiredBeanNames, TypeConverter typeConverter, boolean fallback
   ....
  return this.beanFactory.resolveDependency(
  					new DependencyDescriptor(param, true), beanName, autowiredBeanNames, typeConverter);
}
~~~

문제는 의존성이 해결되지 않으면, Constructor 관련된 Bean은 생성되지 않는다는 것이다. 

이상태에서 Autowired Field 관련된 Bean을 생성하면 ... 
