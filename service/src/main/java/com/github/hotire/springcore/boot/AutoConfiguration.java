package com.github.hotire.springcore.boot;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

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
@AutoConfigurationPackage
@EnableAutoConfiguration
public class AutoConfiguration {
}
