package com.github.hotire.springcore.aop;

import java.util.Collections;
import java.util.List;

import org.springframework.aop.Advisor;
import org.springframework.aop.TargetSource;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.BeansException;

/**
 * @see org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator
 * @see org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator
 * @see org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator
 * @see org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator
 */
public class AnnotationAwareAspectJAutoProxyCreatorCore {

    /**
     * @see org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator#postProcessBeforeInstantiation(Class, String)
     */
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) {
        shouldSkip(beanClass, beanName);
        return null;
    }

    /**
     * @see org.springframework.aop.aspectj.autoproxy.AspectJAwareAdvisorAutoProxyCreator#shouldSkip(Class, String)
     */
    protected boolean shouldSkip(Class<?> beanClass, String beanName) {
        findCandidateAdvisors();
        return false;
    }

    /**
     * @see AnnotationAwareAspectJAutoProxyCreator#findCandidateAdvisors()
     */
    protected List<Advisor> findCandidateAdvisors() {
       return Collections.emptyList();
    }

    /**
     * @see org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator#postProcessAfterInitialization(Object, String)
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) {
       return wrapIfNecessary(bean, beanName, "");
    }

    /**
     * @see org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator#wrapIfNecessary(Object, String, Object)
     */
    protected Object wrapIfNecessary(Object bean, String beanName, Object cacheKey) {
        getAdvicesAndAdvisorsForBean(bean.getClass(), beanName, null);
        return null;
    }

    /**
     * @see org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator#getAdvicesAndAdvisorsForBean(Class, String, TargetSource)
     */
    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName, TargetSource customTargetSource) throws BeansException {
        return findEligibleAdvisors(beanClass, beanName).toArray();
    }

    /**
     * @see org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator#findEligibleAdvisors(Class, String)
     */
    protected List<Advisor> findEligibleAdvisors(Class<?> beanClass, String beanName) {
        return findCandidateAdvisors();
    }
}
