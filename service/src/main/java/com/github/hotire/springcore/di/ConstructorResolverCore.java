package com.github.hotire.springcore.di;

import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;

/**
 * @see org.springframework.beans.factory.support.ConstructorResolver
 */
public class ConstructorResolverCore {

    /**
     * @see org.springframework.beans.factory.support.ConstructorResolver#autowireConstructor(String, RootBeanDefinition, Constructor[], Object[]) 
     */
    public BeanWrapper autowireConstructor(String beanName, RootBeanDefinition mbd,
                                           @Nullable Constructor<?>[] chosenCtors, @Nullable Object[] explicitArgs) {
        return null;
    }

    /**
     * @see org.springframework.beans.factory.support.ConstructorResolver#resolveAutowiredArgument(MethodParameter, String, Set, TypeConverter, boolean) 
     */
    private Object[] resolvePreparedArguments(String beanName, RootBeanDefinition mbd, BeanWrapper bw,
                                              Executable executable, Object[] argsToResolve) {

        return null;
    }
}
