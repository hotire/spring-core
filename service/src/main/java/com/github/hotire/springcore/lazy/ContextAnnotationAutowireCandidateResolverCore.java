package com.github.hotire.springcore.lazy;

import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.lang.Nullable;

/**
 * @see ContextAnnotationAutowireCandidateResolver
 */
public class ContextAnnotationAutowireCandidateResolverCore {


    /**
     * @see ContextAnnotationAutowireCandidateResolver#getLazyResolutionProxyIfNecessary(DependencyDescriptor,
     * String)
     */
    public Object getLazyResolutionProxyIfNecessary(
        DependencyDescriptor descriptor, @Nullable String beanName) {
        return null;
    }

    /**
     * @see ContextAnnotationAutowireCandidateResolver#isLazy(DependencyDescriptor)
     */
    protected boolean isLazy(DependencyDescriptor descriptor) {
        return true;
    }

    /**
     * @see ContextAnnotationAutowireCandidateResolver#buildLazyResolutionProxy(DependencyDescriptor,
     * String)
     */
    protected Object buildLazyResolutionProxy(final DependencyDescriptor descriptor,
        final @Nullable String beanName) {
        return null;
    }
}