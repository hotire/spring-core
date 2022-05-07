package com.github.hotire.springcore.bean.register.object_factory;

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
}
