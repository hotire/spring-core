package com.github.hotire.springcore.bean.register.object_factory;

import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

/**
 * @see DefaultListableBeanFactory
 */
public class ObjectProviderDefaultListableBeanFactoryCore {

    /**
     * @see DefaultListableBeanFactory#resolveDependency(DependencyDescriptor, String, Set, TypeConverter) 
     */
    public Object resolveDependency(DependencyDescriptor descriptor, @Nullable String requestingBeanName,
                                    @Nullable Set<String> autowiredBeanNames, @Nullable TypeConverter typeConverter) throws BeansException {
        
        if (ObjectFactory.class == descriptor.getDependencyType() ||
                 ObjectProvider.class == descriptor.getDependencyType()) {
            return null;
        }
        
        return null;
    }

    /**
     * @see org.springframework.beans.factory.ListableBeanFactory#getBeanProvider(Class) 
     * @see DefaultListableBeanFactory#getBeanProvider(Class) 
     */
    public <T> ObjectProvider<T> getBeanProvider(Class<T> requiredType) {
        Assert.notNull(requiredType, "Required type must not be null");
        return null;
    }
    
}
