package com.github.hotire.springcore.env;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @see EnvironmentPostProcessor
 */
public class EnvironmentPostProcessorCore {

    /**
     * @see EnvironmentPostProcessor#postProcessEnvironment(ConfigurableEnvironment, SpringApplication)
     * @see org.springframework.boot.context.config.ConfigDataEnvironmentPostProcessor#postProcessEnvironment(ConfigurableEnvironment, SpringApplication)
     */
    void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

    }
}
