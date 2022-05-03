package com.github.hotire.springcore.boot.run;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.DefaultBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.metrics.ApplicationStartup;

import com.github.hotire.springcore.boot.SpringApplicationEventListener;

/**
 * @see SpringApplication
 */
public class SpringApplicationCore {

    private final WebApplicationType webApplicationType;
    private final ApplicationContextFactory applicationContextFactory = ApplicationContextFactory.DEFAULT;
    private final ApplicationStartup applicationStartup = ApplicationStartup.DEFAULT;

    public static ConfigurableApplicationContext run(Class<?>[] primarySources, String[] args) {
        return new SpringApplication(primarySources).run(args);
    }

    public SpringApplicationCore() {
        this.webApplicationType = WebApplicationTypeCore.deduceFromClasspath();
    }


    /**
     * @see SpringApplication#run(String...)
     */
    public ConfigurableApplicationContext run(String... args) {
        final DefaultBootstrapContext bootstrapContext = createBootstrapContext();
        final SpringApplicationEventListener listeners = getRunListeners(args);
        ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
        try {
            final ConfigurableEnvironment environment = prepareEnvironment(listeners, bootstrapContext, applicationArguments); // property load (System or yml...)
            configureIgnoreBeanInfo(environment);
            Banner printedBanner = printBanner(environment);
            final ConfigurableApplicationContext context = createApplicationContext();
            context.setApplicationStartup(this.applicationStartup);
            prepareContext(bootstrapContext, context, environment, listeners, applicationArguments, printedBanner);
            refreshContext(context);
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * @see SpringApplication#createApplicationContext()
     */
    private DefaultBootstrapContext createBootstrapContext() {
        DefaultBootstrapContext bootstrapContext = new DefaultBootstrapContext();
        return bootstrapContext;
    }

    /**
     * @see SpringApplication#getListeners()
     */
    private SpringApplicationEventListener getRunListeners(String[] args) {
        return null;
    }

    /**
     * @see SpringApplication#prepareEnvironment(org.springframework.boot.SpringApplicationRunListeners, DefaultBootstrapContext, ApplicationArguments)
     */
    private ConfigurableEnvironment prepareEnvironment(SpringApplicationEventListener listeners,
                                                       DefaultBootstrapContext bootstrapContext, ApplicationArguments applicationArguments) {
        return getOrCreateEnvironment();
    }

    /**
     * @see SpringApplication#configureIgnoreBeanInfo(ConfigurableEnvironment)
     */
    private void configureIgnoreBeanInfo(ConfigurableEnvironment environment) {

    }

    /**
     * @see SpringApplication#printBanner(ConfigurableEnvironment)
     */
    private Banner printBanner(ConfigurableEnvironment environment) {
        return (environment1, sourceClass, out) -> { };
    }

    /**
     * @see SpringApplication#getOrCreateEnvironment()
     */
    private ConfigurableEnvironment getOrCreateEnvironment() {
        return null;
    }

    /**
     * @see SpringApplication#createApplicationContext()
     */
    protected ConfigurableApplicationContext createApplicationContext() {
        return this.applicationContextFactory.create(this.webApplicationType);
    }

    /**
     * @see SpringApplication#refreshContext(ConfigurableApplicationContext)
     * @see AbstractApplicationContext#refresh()
     */
    private void refreshContext(ConfigurableApplicationContext context) {
        context.refresh();
    }

    /**
     * @see SpringApplication#afterRefresh(ConfigurableApplicationContext, ApplicationArguments)
     */
    protected void afterRefresh(ConfigurableApplicationContext context, ApplicationArguments args) {
    }

    /**
     * @see SpringApplication#prepareContext(DefaultBootstrapContext, ConfigurableApplicationContext, ConfigurableEnvironment, org.springframework.boot.SpringApplicationRunListeners, ApplicationArguments, Banner)
     */
    private void prepareContext(DefaultBootstrapContext bootstrapContext, ConfigurableApplicationContext context,
                                ConfigurableEnvironment environment, SpringApplicationEventListener listeners,
                                ApplicationArguments applicationArguments, Banner printedBanner) {
        context.setEnvironment(environment);
        postProcessApplicationContext(context);

    }

    /**
     * Apply any relevant post processing the ApplicationContext
     * @see SpringApplication#postProcessApplicationContext(ConfigurableApplicationContext)
     */
    protected void postProcessApplicationContext(ConfigurableApplicationContext context) {

    }
    
}
