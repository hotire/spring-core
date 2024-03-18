package com.github.hotire.springcore.bean_factory_post_processor.example;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private final SimpleClassPathScanningCandidateComponentProvider provider = new SimpleClassPathScanningCandidateComponentProvider();
    private BeanDefinitionRegistry registry;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
        throws BeansException {
        final List<BeanDefinition> beanDefinitions = AutoConfigurationPackages.get(beanFactory).stream()
            .flatMap( basePackage -> provider.findCandidateComponents(basePackage).stream())
            .collect(Collectors.toList());
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)
        throws BeansException {
        this.registry = registry;
    }
}
