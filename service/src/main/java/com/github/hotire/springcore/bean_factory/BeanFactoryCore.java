package com.github.hotire.springcore.bean_factory;

import java.lang.reflect.Constructor;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.NamedBeanHolder;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;

/**
 * @see BeanFactory
 * @see org.springframework.beans.factory.ListableBeanFactory
 * @see org.springframework.beans.factory.HierarchicalBeanFactory
 * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory
 *
 *
 * @see org.springframework.beans.factory.config.ConfigurableBeanFactory
 * @see org.springframework.beans.factory.config.ConfigurableListableBeanFactory
 *
 * @see org.springframework.beans.factory.support.AbstractBeanFactory
 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory
 * @see org.springframework.beans.factory.support.DefaultListableBeanFactory
 */
public class BeanFactoryCore {

    /**
     * @see BeanFactory#getBean(String)
     * @see AbstractBeanFactory#getBean(String)
     */
    public <T> T getBean(String name) throws BeansException {
        return doGetBean(name, null, null, false);
    }

    /**
     *  @see BeanFactory#getBean(Class)
     *  @see DefaultListableBeanFactory#getBean(Class)
     */
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return getBean(requiredType, (Object[]) null);
    }

    /**
     * @see BeanFactory#getBean(Class, Object...)
     * @see DefaultListableBeanFactory#getBean(Class, Object...)
     */
    public <T> T getBean(Class<T> requiredType, @Nullable Object... args) throws BeansException {
        return (T) resolveNamedBean(ResolvableType.forRawClass(requiredType), args, false).getBeanInstance();
    }
    
    /**
     * @see DefaultListableBeanFactory#resolveNamedBean(ResolvableType, Object[], boolean)
     */
    private <T> NamedBeanHolder<T> resolveNamedBean(
            ResolvableType requiredType, @Nullable Object[] args, boolean nonUniqueAsNull) throws BeansException {
        return resolveNamedBean("name", requiredType, args);
    }

    /**
     * @see DefaultListableBeanFactory#resolveNamedBean(String, ResolvableType, Object[])
     */
    private <T> NamedBeanHolder<T> resolveNamedBean(
            String beanName, ResolvableType requiredType, @Nullable Object[] args) throws BeansException {
        return getBean(beanName, null, args);
    }

    /**
     * @see AbstractBeanFactory#getBean(String, Class, Object...)
     */
    public <T> T getBean(String name, @Nullable Class<T> requiredType, @Nullable Object... args)
            throws BeansException {

        return doGetBean(name, requiredType, args, false);
    }

    /**
     * @see AbstractBeanFactory#doGetBean(String, Class, Object[], boolean)
     */
    protected <T> T doGetBean(
            String name, @Nullable Class<T> requiredType, @Nullable Object[] args, boolean typeCheckOnly)
            throws BeansException {
        return (T) createBean(name, null, args);
    }

    /**
     * @see AbstractBeanFactory#createBean(String, RootBeanDefinition, Object[])
     * @see AbstractAutowireCapableBeanFactory#createBean(String, RootBeanDefinition, Object[])
     */
    protected Object createBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args)
            throws BeanCreationException {
        return null;
    }

    /**
     * @see AbstractAutowireCapableBeanFactory#doCreateBean(String, RootBeanDefinition, Object[])
     */
    protected Object doCreateBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args)
            throws BeanCreationException {

        final BeanWrapper wrapper = createBeanInstance(beanName, mbd, args); // 1. create
        Object exposedObject = wrapper.getWrappedInstance();
        populateBean(beanName, mbd, wrapper); // 2. DI
        exposedObject = initializeBean(beanName, exposedObject, mbd); // 3. init
        return exposedObject;
    }

    /**
     * @see AbstractAutowireCapableBeanFactory#createBeanInstance(String, RootBeanDefinition, Object[])
     */
    protected BeanWrapper createBeanInstance(String beanName, RootBeanDefinition mbd, @Nullable Object[] args) {
        final Constructor<?>[] ctors = determineConstructorsFromBeanPostProcessors(mbd.getBeanClass(), beanName);
        if (ctors != null) {
            return autowireConstructor(beanName, mbd, null, args);
        }
        return instantiateBean(beanName, mbd);
    }

    /**
     * @see AbstractAutowireCapableBeanFactory#determineConstructorsFromBeanPostProcessors(Class, String)
     * @see org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor#determineCandidateConstructors(Class, String)
     */
    protected Constructor<?>[] determineConstructorsFromBeanPostProcessors(@Nullable Class<?> beanClass, String beanName)
            throws BeansException {
//        bp.determineCandidateConstructors(beanClass, beanName) // SmartInstantiationAwareBeanPostProcessor
        return null;
    }

    /**
     * @see AbstractAutowireCapableBeanFactory#autowireConstructor(String, RootBeanDefinition, Constructor[], Object[])
     * @see org.springframework.beans.factory.support.ConstructorResolver#autowireConstructor(String, RootBeanDefinition, Constructor[], Object[])
     */
    protected BeanWrapper autowireConstructor(
            String beanName, RootBeanDefinition mbd, @Nullable Constructor<?>[] ctors, @Nullable Object[] explicitArgs) {
        return null;
    }

    /**
     * @see AbstractAutowireCapableBeanFactory#instantiateBean(String, RootBeanDefinition)
     */
    protected BeanWrapper instantiateBean(String beanName, RootBeanDefinition mbd) {
        return null;
    }

    // DI

    /**
     * @see AbstractAutowireCapableBeanFactory#populateBean(String, RootBeanDefinition, BeanWrapper)
     */
    protected void populateBean(String beanName, RootBeanDefinition mbd, @Nullable BeanWrapper bw) {

    }

    // initializeBean

    /**
     * @see AbstractAutowireCapableBeanFactory#initializeBean(String, Object, RootBeanDefinition)
     */
    protected Object initializeBean(String beanName, Object bean, @Nullable RootBeanDefinition mbd) {

        applyBeanPostProcessorsBeforeInitialization(bean, beanName);
        try {
            invokeInitMethods(beanName, bean, mbd);
        } catch (Throwable ex) {
            throw new BeanCreationException(
                    (mbd != null ? mbd.getResourceDescription() : null),
                    beanName, "Invocation of init method failed", ex);
        }
        applyBeanPostProcessorsAfterInitialization(bean, beanName);
        return null;
    }

    /**
     * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory#applyBeanPostProcessorsBeforeInitialization(Object, String)
     */
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
            throws BeansException {
        return null;
    }

    /**
     * @see AbstractAutowireCapableBeanFactory#invokeInitMethods(String, Object, RootBeanDefinition)
     */
    protected void invokeInitMethods(String beanName, Object bean, @Nullable RootBeanDefinition mbd)
            throws Throwable {

    }

    /**
     * @see org.springframework.beans.factory.config.AutowireCapableBeanFactory#applyBeanPostProcessorsAfterInitialization(Object, String)
     */
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws BeansException {
        return null;
    }

}
