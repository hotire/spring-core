package com.github.hotire.springcore.env;

import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.config.ConfigDataEnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ResourceLoader;

/**
 * @see ConfigDataEnvironmentPostProcessor
 */
public class ConfigDataEnvironmentPostProcessorCore {

    /**
     * @see ConfigDataEnvironmentPostProcessor#postProcessEnvironment(ConfigurableEnvironment, SpringApplication)
     */
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        postProcessEnvironment(environment, application.getResourceLoader(), application.getAdditionalProfiles());
    }

    /**
     * @see ConfigDataEnvironmentPostProcessor#postProcessEnvironment(ConfigurableEnvironment, ResourceLoader, Collection)
     */
    void postProcessEnvironment(ConfigurableEnvironment environment, ResourceLoader resourceLoader,
                                Collection<String> additionalProfiles) {
        getConfigDataEnvironment(environment, resourceLoader, additionalProfiles).processAndApply();
    }

    /**
     * @see ConfigDataEnvironmentPostProcessor#getConfigDataEnvironment(ConfigurableEnvironment, ResourceLoader, Collection) 
     */
    ConfigDataEnvironmentCore getConfigDataEnvironment(ConfigurableEnvironment environment, ResourceLoader resourceLoader,
                                                   Collection<String> additionalProfiles) {
        return new ConfigDataEnvironmentCore(environment);
    }
}
