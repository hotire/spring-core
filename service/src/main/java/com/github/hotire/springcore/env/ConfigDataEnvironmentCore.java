package com.github.hotire.springcore.env;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @see org.springframework.boot.context.config.ConfigDataEnvironment
 */
public class ConfigDataEnvironmentCore {

    private final ConfigDataEnvironmentContributorsCore contributors;

    /**
     * @see org.springframework.boot.context.config.ConfigDataEnvironment.IMPORT_PROPERTY
     */
    static final String IMPORT_PROPERTY = "spring.config.import";

    /**
     * @see org.springframework.boot.context.config.ConfigDataEnvironment#processAndApply()
     */
    public void processAndApply() {

    }

    public ConfigDataEnvironmentCore(ConfigurableEnvironment environment) {
        Binder binder = Binder.get(environment);
        this.contributors = createContributors(binder);
    }

    /**
     * @see org.springframework.boot.context.config.ConfigDataEnvironment#createContributors(Binder)
     */
    private ConfigDataEnvironmentContributorsCore createContributors(Binder binder) {
        getInitialImportContributors(binder);
        return null;
    }

    /**
     * @see org.springframework.boot.context.config.ConfigDataEnvironment#getInitialImportContributors(Binder)
     */
    private List<ConfigDataEnvironmentContributorCore> getInitialImportContributors(Binder binder) {
        return Collections.emptyList();
    }

    /**
     * @see org.springframework.boot.context.config.ConfigDataEnvironmentContributors;
     */
    private static class ConfigDataEnvironmentContributorsCore {
        
    }

    public static class ConfigDataEnvironmentContributorCore {

    }
}
