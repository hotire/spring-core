package com.github.hotire.springcore.boot.auto;

import java.util.List;

import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.Assert;

import lombok.Getter;

/**
 * @see AutoConfigurationImportSelector
 */
public class AutoConfigurationImportSelectorCore {

    @Getter
    private ClassLoader beanClassLoader;

    /**
     * @see AutoConfigurationImportSelector#getCandidateConfigurations(AnnotationMetadata, AnnotationAttributes)
     */
    protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
        List<String> configurations = SpringFactoriesLoader.loadFactoryNames(getSpringFactoriesLoaderFactoryClass(),
                                                                             getBeanClassLoader());
        Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you "
                                        + "are using a custom packaging, make sure that file is correct.");
        return configurations;
    }

    protected Class<?> getSpringFactoriesLoaderFactoryClass() {
        return EnableAutoConfiguration.class;
    }
}
