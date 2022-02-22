package com.github.hotire.springcore.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * @see ResourceLoader
 * @see org.springframework.core.io.support.ResourcePatternResolver
 * @see org.springframework.core.io.DefaultResourceLoader
 */
public class CustomResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }
}
