package com.github.hotire.springcore.boot.auto;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

/**
 * @see org.springframework.boot.autoconfigure.AutoConfigurationPackage
 * @see org.springframework.boot.autoconfigure.AutoConfigurationPackages.Registrar
 *
 */
public class AutoConfigurationPackageCore {

    /**
     * @see org.springframework.boot.autoconfigure.AutoConfigurationPackages#get(BeanFactory) 
     */
    public static List<String> get(BeanFactory beanFactory) {
        try {
            return List.of();
        }
        catch (NoSuchBeanDefinitionException ex) {
            throw new IllegalStateException("Unable to retrieve @EnableAutoConfiguration base packages");
        }
    }
}
