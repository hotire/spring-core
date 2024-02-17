package com.github.hotire.springcore.bean_factory;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.beans.factory.support.AbstractBeanFactory;

/**
 * @see ConfigurableBeanFactory
 * @see AbstractBeanFactory
 */
public interface ConfigurableBeanFactoryCore {


    /**
     * @see AbstractBeanFactory#scopes
     */
    Map<String, Scope> scopes = new LinkedHashMap<>(8);

    /**
     * @see ConfigurableBeanFactory#registerScope(String, Scope) 
     * @see AbstractBeanFactory#registerScope(String, Scope)
     */
    void registerScope(String scopeName, Scope scope);
}
