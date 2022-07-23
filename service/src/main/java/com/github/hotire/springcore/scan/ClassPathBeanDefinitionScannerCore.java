package com.github.hotire.springcore.scan;

import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * @see ClassPathBeanDefinitionScanner
 */
public class ClassPathBeanDefinitionScannerCore {

    /**
     * @see ClassPathBeanDefinitionScanner#scan(String...)
     */
    public int scan(String... basePackages) {
       return 0;
    }

    /**
     * @see ClassPathBeanDefinitionScanner#doScan(String...) 
     */
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return Set.of();
    }
}
