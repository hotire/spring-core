package com.github.hotire.springcore.boot;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.context.annotation.DeterminableImports;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class DefaultAutoConfigurationPackages extends AutoConfigurationPackages {

    public static class CustomRegister implements ImportBeanDefinitionRegistrar, DeterminableImports {

        @Override
        public Set<Object> determineImports(AnnotationMetadata metadata) {
            return Collections.emptySet();
        }

        @Override
        public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        }
    }
}
