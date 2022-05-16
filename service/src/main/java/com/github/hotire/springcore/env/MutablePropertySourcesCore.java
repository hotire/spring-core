package com.github.hotire.springcore.env;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.core.env.PropertySource;

/**
 * @see org.springframework.core.env.MutablePropertySources
 */
public class MutablePropertySourcesCore {

    private final List<PropertySource<?>> propertySourceList = new CopyOnWriteArrayList<>();

    public PropertySource<?> get(String name) {
        for (PropertySource<?> propertySource : this.propertySourceList) {
            if (propertySource.getName().equals(name)) {
                return propertySource;
            }
        }
        return null;
    }

}
