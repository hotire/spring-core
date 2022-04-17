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
        return null;
    }

    /**
     * @see AbstractAutowireCapableBeanFactory#createBeanInstance(String, RootBeanDefinition, Object[])
     */
    protected BeanWrapper createBeanInstance(String beanName, RootBeanDefinition mbd, @Nullable Object[] args) {
        autowireConstructor(beanName, mbd, null, args);
        return instantiateBean(beanName, mbd);
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
     * @see AbstractAutowireCapableBeanFactory#initializeBean(String, Object, RootBeanDefinition)
     */
    protected BeanWrapper instantiateBean(String beanName, RootBeanDefinition mbd) {
        return null;
    }

}
