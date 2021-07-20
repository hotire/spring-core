# Method constraints in inheritance hierarchies

https://beanvalidation.org/1.1/spec/#constraintdeclarationvalidationprocess-methodlevelconstraints-inheritance

### ServletInvocableHandlerMethod

### MethodValidationInterceptor

~~~java
try {
    result = execVal.validateParameters(target, methodToValidate, invocation.getArguments(), groups);
}
~~~
### ExecutableValidator

### BeanMetaDataManager

### BeanMetaDataBuilder

### BuilderDelegate

### ExecutableMetaData.Builder

### MethodConfigurationRule (OverridingMethodMustNotAlterParameterConstraints)

~~~java
public class OverridingMethodMustNotAlterParameterConstraints extends MethodConfigurationRule {

	@Override
	public void apply(ConstrainedExecutable method, ConstrainedExecutable otherMethod) {
		if ( isDefinedOnSubType( method, otherMethod ) &&
				otherMethod.hasParameterConstraints() &&
				!method.isEquallyParameterConstrained( otherMethod ) ) {
			throw LOG.getParameterConfigurationAlteredInSubTypeException(
					method.getCallable(),
					otherMethod.getCallable()
			);
		}
	}
}
~~~