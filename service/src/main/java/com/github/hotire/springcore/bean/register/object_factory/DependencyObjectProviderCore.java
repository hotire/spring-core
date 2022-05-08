package com.github.hotire.springcore.bean.register.object_factory;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.lang.Nullable;

import lombok.RequiredArgsConstructor;

/**
 * @see org.springframework.beans.factory.support.DefaultListableBeanFactory.DependencyObjectProvider
 */
@RequiredArgsConstructor
public class DependencyObjectProviderCore implements BeanObjectProviderCore<Object> {
    private final DependencyDescriptor descriptor;
    private final boolean optional;
    @Nullable
    private final String beanName;

    @Override
    public Object getObject(Object... args) throws BeansException {
        if (this.optional) {
            return createOptionalDependency(this.descriptor, this.beanName);
        } else {
            Object result = doResolveDependency(this.descriptor, this.beanName, null, null);
            if (result == null) {
                throw new NoSuchBeanDefinitionException(this.descriptor.getResolvableType());
            }
            return result;
        }
    }

    @Override
    public Object getIfAvailable() throws BeansException {
        return null;
    }

    @Override
    public Object getIfUnique() throws BeansException {
        return null;
    }

    @Override
    public Object getObject() throws BeansException {
        return null;
    }

    private Optional<?> createOptionalDependency(
            DependencyDescriptor descriptor, @Nullable String beanName, final Object... args) {
        return Optional.empty();
    }

    public Object doResolveDependency(DependencyDescriptor descriptor, @Nullable String beanName,
                                      @Nullable Set<String> autowiredBeanNames, @Nullable TypeConverter typeConverter) throws BeansException {
        return null;
    }
}
