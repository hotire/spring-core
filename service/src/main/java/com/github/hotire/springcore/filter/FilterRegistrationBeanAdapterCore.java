package com.github.hotire.springcore.filter;


import javax.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;

/**
 * @see org.springframework.boot.web.servlet.ServletContextInitializerBeans.RegistrationBeanAdapter
 * @see org.springframework.boot.web.servlet.ServletContextInitializerBeans.FilterRegistrationBeanAdapter
 */
public class FilterRegistrationBeanAdapterCore {

    /**
     * @see org.springframework.boot.web.servlet.ServletContextInitializerBeans.FilterRegistrationBeanAdapter#createRegistrationBean(String, Filter, int)
     */
    public RegistrationBean createRegistrationBean(String name, Filter source, int totalNumberOfSourceBeans) {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(source);
        bean.setName(name);
        return bean;
    }

}
