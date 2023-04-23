package com.github.hotire.springcore.filter;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import org.springframework.boot.web.servlet.AbstractFilterRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

/**
 * @see AbstractFilterRegistrationBean
 * @see FilterRegistrationBean;
 */
public class FilterRegistrationBeanCore {

    /**
     * @see AbstractFilterRegistrationBean#dispatcherTypes
     */
    private EnumSet<DispatcherType> dispatcherTypes;

    /**
     * @see org.springframework.boot.web.servlet.RegistrationBean#onStartup(ServletContext) 
     * @see org.springframework.boot.web.servlet.DynamicRegistrationBean#register(String, ServletContext) 
     * @see FilterRegistrationBean#configure(Dynamic) 
     */
    protected void configure(FilterRegistration.Dynamic registration) {

    }
}
