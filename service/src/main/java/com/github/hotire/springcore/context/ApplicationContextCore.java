package com.github.hotire.springcore.context;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.Banner;
import org.springframework.boot.DefaultBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.DefaultLifecycleProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.support.GenericWebApplicationContext;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @see ApplicationContext
 * @see ConfigurableApplicationContext
 * @see AbstractApplicationContext
 */
@Slf4j
public class ApplicationContextCore {

    private long startupDate;

    /** Flag that indicates whether this context is currently active. */
    private final AtomicBoolean active = new AtomicBoolean();

    /** Flag that indicates whether this context has been closed already. */
    private final AtomicBoolean closed = new AtomicBoolean();

    @Getter
    private final String displayName = ObjectUtils.identityToString(this);

    /** Statically specified listeners. */
    private final Set<ApplicationListener<?>> applicationListeners = new LinkedHashSet<>();

    /** Local listeners registered before refresh. */
    private Set<ApplicationListener<?>> earlyApplicationListeners;

    private Set<ApplicationEvent> earlyApplicationEvents;

    /**
     * @see SpringApplication#prepareContext(DefaultBootstrapContext, ConfigurableApplicationContext, ConfigurableEnvironment, org.springframework.boot.SpringApplicationRunListeners, ApplicationArguments, Banner)
     * context.setEnvironment(environment);
     */
    @Getter
    private ConfigurableEnvironment environment;

    @Getter
    private final LifecycleProcessor lifecycleProcessor = new DefaultLifecycleProcessor();

    /**
     * @see ConfigurableApplicationContext#refresh()
     * @see AbstractApplicationContext#refresh()
     */
    public void refresh() throws BeansException, IllegalStateException {

        prepareRefresh();

        ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

        prepareBeanFactory(beanFactory);

        // Allows post-processing of the bean factory in context subclasses.
        postProcessBeanFactory(beanFactory);

        invokeBeanFactoryPostProcessors(beanFactory);

        // Last step: publish corresponding event.
        finishRefresh();

    }

    /**
     * @see AbstractApplicationContext#prepareRefresh()
     */
    protected void prepareRefresh() {
        // Switch to active.
        this.startupDate = System.currentTimeMillis();
        this.closed.set(false);
        this.active.set(true);

        if (log.isDebugEnabled()) {
            if (log.isTraceEnabled()) {
                log.trace("Refreshing " + this);
            } else {
                log.debug("Refreshing " + getDisplayName());
            }
        }

        // Initialize any placeholder property sources in the context environment.
        initPropertySources();

        // Validate that all properties marked as required are resolvable:
        // see ConfigurablePropertyResolver#setRequiredProperties
        getEnvironment().validateRequiredProperties();

        // Store pre-refresh ApplicationListeners...
        if (this.earlyApplicationListeners == null) {
            this.earlyApplicationListeners = new LinkedHashSet<>(this.applicationListeners);
        } else {
            // Reset local application listeners to pre-refresh state.
            this.applicationListeners.clear();
            this.applicationListeners.addAll(this.earlyApplicationListeners);
        }

        // Allow for the collection of early ApplicationEvents,
        // to be published once the multicaster is available...
        this.earlyApplicationEvents = new LinkedHashSet<>();
    }

    /**
     * @see AbstractApplicationContext#initPropertySources()
     * @see GenericWebApplicationContext#initPropertySources()
     */
    protected void initPropertySources() {
        // For subclasses: do nothing by default.
    }

    /**
     * @see AbstractApplicationContext#obtainFreshBeanFactory()
     */
    protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
        return null;
    }

    /**
     * @see AbstractApplicationContext#prepareBeanFactory(ConfigurableListableBeanFactory)
     * Configure the factory's standard context characteristics,
     * such as the context's ClassLoader and post-processors.
     * beanFactory의 ClassLoader, post-processors와 같은 표준 구성한다.
     */
    protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {

    }

    /**
     * @see AbstractApplicationContext#finishRefresh()
     */
    protected void finishRefresh() {
        getLifecycleProcessor().onRefresh();
    }

    /**
     * @see AbstractApplicationContext#postProcessBeanFactory(ConfigurableListableBeanFactory)
     * @see org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext#postProcessBeanFactory(ConfigurableListableBeanFactory)
     * @see org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext#postProcessBeanFactory(ConfigurableListableBeanFactory)
     * 초기화 이후 beanFactory를 수정합니다. 모든 bean definitions은 로드되었을 것이지만 bean은 생성되지 않았다.
     * 특정 BeanPostProcessors 와 같이 등록을 허용한다.
     *
     * 해당 부분에서 AnnotationConfigServletWebServerApplicationContext scan이 이루어진다.
     * + registerWebApplicationScopes() web전용 bean scopre도 등록된다.
     */
    protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
    }

    /**
     * @see AbstractApplicationContext#invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory)
     * 등록된 BeanFactoryPostProcessor 을 인스턴스화하고 모두 호출한다.
     *
     * BeanFactoryPostProcessor 확장한 BeanDefinitionRegistryPostProcessor도 추가적으로 호출된다.
     *
     * BeanDefinitionRegistryPostProcessor 대표적으로 ConfigurationClassPostProcessor
     */
    protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {

    }

    /**
     * @see AbstractApplicationContext#registerBeanPostProcessors(ConfigurableListableBeanFactory)
     *
     * 모든 BeanPostProcessor Bean을 인스턴스화하고 등록합니다.
     */
    protected void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {

    }

}
