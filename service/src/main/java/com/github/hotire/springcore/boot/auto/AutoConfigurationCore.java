package com.github.hotire.springcore.boot.auto;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * EnableAutoConfiguration has AutoConfigurationPackage annoation
 *
 * @Import(AutoConfigura`tionPackages.Registrar.class)
 *
 * @see org.springframework.boot.autoconfigure.SpringBootApplication
 * @see EnableAutoConfiguration
 * @see AutoConfigurationPackage
 * @see org.springframework.boot.autoconfigure.AutoConfigurationPackages.Registrar is ImportBeanDefinitionRegistrar
 * @see AutoConfigurationImportSelector
 * 
 * 2.7.0 after
 * @see AutoConfiguration
 * @see AutoConfigurationImportSelector#getCandidateConfigurations(AnnotationMetadata, AnnotationAttributes) 
 */
@Slf4j
@Configuration
@MyAutoConfigurationPackage
public class AutoConfigurationCore implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        final List<String> basePackages = AutoConfigurationPackages.get(beanFactory);
        basePackages.forEach(log::info);
    }
}
