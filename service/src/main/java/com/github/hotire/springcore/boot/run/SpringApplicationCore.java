package com.github.hotire.springcore.boot.run;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.DefaultBootstrapContext;
import org.springframework.boot.LazyInitializationBeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.metrics.ApplicationStartup;
import org.springframework.util.Assert;

import com.github.hotire.springcore.boot.SpringApplicationRunListenersCore;
import com.github.hotire.springcore.boot.webtype.env.ApplicationEnvironmentCore;
import com.github.hotire.springcore.boot.webtype.env.ApplicationReactiveWebEnvironmentCore;
import com.github.hotire.springcore.boot.webtype.env.ApplicationServletEnvironmentCore;
import com.github.hotire.springcore.context.ApplicationContextCore;

import lombok.Getter;

/**
 * @see SpringApplication
 */
public class SpringApplicationCore {

    private final WebApplicationType webApplicationType;
    private final ApplicationContextFactory applicationContextFactory = ApplicationContextFactory.DEFAULT;
    private final ApplicationStartup applicationStartup = ApplicationStartup.DEFAULT;

    @Getter
    private List<ApplicationContextInitializer<?>> initializers;
    private boolean allowBeanDefinitionOverriding;
    private boolean allowCircularReferences;

    private final boolean lazyInitialization = false;

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
        long startTime = System.nanoTime();
        final DefaultBootstrapContext bootstrapContext = createBootstrapContext();
        ConfigurableApplicationContext context = null;
        configureHeadlessProperty();
        final SpringApplicationRunListenersCore listeners = getRunListeners(args);
        ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
        try {
            final ConfigurableEnvironment environment = prepareEnvironment(listeners, bootstrapContext, applicationArguments); // property load (System or yml...)
            configureIgnoreBeanInfo(environment);
            Banner printedBanner = printBanner(environment);
            context = createApplicationContext();
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
     * @see SpringApplication#configureHeadlessProperty()
     * GUI 설정
     */
    private void configureHeadlessProperty() {

    }

    /**
     * @see SpringApplication#getRunListeners(String[])
     */
    private SpringApplicationRunListenersCore getRunListeners(String[] args) {
        return new SpringApplicationRunListenersCore();
    }

    /**
     * @see SpringApplication#prepareEnvironment(org.springframework.boot.SpringApplicationRunListeners, DefaultBootstrapContext, ApplicationArguments)
     */
    private ConfigurableEnvironment prepareEnvironment(SpringApplicationRunListenersCore listeners,
                                                       DefaultBootstrapContext bootstrapContext, ApplicationArguments applicationArguments) {
        final ConfigurableEnvironment environment = getOrCreateEnvironment();
        configureEnvironment(environment, applicationArguments.getSourceArgs());
        ConfigurationPropertySources.attach(environment); // Support ConfigurationPropertySource
        listeners.environmentPrepared(bootstrapContext, environment);
        return environment;
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
        switch (this.webApplicationType) {
            case SERVLET:
                return new ApplicationServletEnvironmentCore();
            case REACTIVE:
                return new ApplicationReactiveWebEnvironmentCore();
            default:
                return new ApplicationEnvironmentCore();
        }
    }

    /**
     * @see SpringApplication#configureEnvironment(ConfigurableEnvironment, String[])
     * @see SpringApplication#configurePropertySources(ConfigurableEnvironment, String[])
     * @see SpringApplication#configureProfiles(ConfigurableEnvironment, String[])
     */
    protected void configureEnvironment(ConfigurableEnvironment environment, String[] args) {
//        configurePropertySources(environment, args);
//        configureProfiles(environment, args);
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
     * @see ApplicationContextCore#refresh()
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
                                ConfigurableEnvironment environment, SpringApplicationRunListenersCore listeners,
                                ApplicationArguments applicationArguments, Banner printedBanner) {
        context.setEnvironment(environment);
        postProcessApplicationContext(context);
        applyInitializers(context);
        listeners.contextPrepared(context);
        bootstrapContext.close(context);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        beanFactory.registerSingleton("springApplicationArguments", applicationArguments);
        if (printedBanner != null) {
            beanFactory.registerSingleton("springBootBanner", printedBanner);
        }
        if (beanFactory instanceof AbstractAutowireCapableBeanFactory) {
            ((AbstractAutowireCapableBeanFactory) beanFactory).setAllowCircularReferences(this.allowCircularReferences);
            if (beanFactory instanceof DefaultListableBeanFactory) {
                ((DefaultListableBeanFactory) beanFactory)
                        .setAllowBeanDefinitionOverriding(this.allowBeanDefinitionOverriding);
            }
        }
        if (this.lazyInitialization) {
            context.addBeanFactoryPostProcessor(new LazyInitializationBeanFactoryPostProcessor());
        }
        // TODO Load the sources
    }

    /**
     * Apply any relevant post processing the ApplicationContext
     * @see SpringApplication#postProcessApplicationContext(ConfigurableApplicationContext)
     */
    protected void postProcessApplicationContext(ConfigurableApplicationContext context) {

    }

    /**
     * @see SpringApplication#applyInitializers(ConfigurableApplicationContext)
     */
    protected void applyInitializers(ConfigurableApplicationContext context) {
        for (ApplicationContextInitializer initializer : getInitializers()) {
            Class<?> requiredType = GenericTypeResolver.resolveTypeArgument(initializer.getClass(),
                                                                            ApplicationContextInitializer.class);
            Assert.isInstanceOf(requiredType, context, "Unable to call initializer.");
            initializer.initialize(context);
        }
    }

}
