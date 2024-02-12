package com.github.hotire.springcore.bean_factory;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * @see ConfigurableBeanFactory
 */
public interface ConfigurableBeanFactoryCore {

    /**
     * @see ConfigurableBeanFactory#registerScope(String, Scope) 
     */
    void registerScope(String scopeName, Scope scope);
}
