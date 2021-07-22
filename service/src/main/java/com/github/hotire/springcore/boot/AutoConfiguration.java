package com.github.hotire.springcore.boot;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * EnableAutoConfiguration has AutoConfigurationPackage annoation
 *
 * @Import(AutoConfigurationPackages.Registrar.class)
 *
 * @see org.springframework.boot.autoconfigure.SpringBootApplication
 * @see EnableAutoConfiguration
 * @see AutoConfigurationPackage
 * @see org.springframework.boot.autoconfigure.AutoConfigurationPackages.Registrar is ImportBeanDefinitionRegistrar
 */
@Slf4j
@Configuration
public class AutoConfiguration implements BeanFactoryAware {

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        final List<String> basePackages = AutoConfigurationPackages.get(beanFactory);
        basePackages.forEach(log::info);
    }
}
