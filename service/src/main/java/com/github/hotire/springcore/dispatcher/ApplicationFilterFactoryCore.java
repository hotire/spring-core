package com.github.hotire.springcore.dispatcher;

import javax.servlet.DispatcherType;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import org.apache.catalina.Wrapper;
import org.apache.catalina.core.ApplicationFilterChain;
import org.apache.catalina.core.ApplicationFilterFactory;
import org.apache.tomcat.util.descriptor.web.FilterMap;

/**
 * @see ApplicationFilterFactory
 */
public class ApplicationFilterFactoryCore {


    /**
     * @see ApplicationFilterFactory#createFilterChain(ServletRequest, Wrapper, Servlet)
     */
    public static ApplicationFilterChain createFilterChain(ServletRequest request,
        Wrapper wrapper, Servlet servlet) {
        return ApplicationFilterFactory.createFilterChain(request, wrapper, servlet);
    }

    /**
     * @see ApplicationFilterFactory#matchDispatcher(FilterMap, DispatcherType) 
     */
    private static boolean matchDispatcher(FilterMap filterMap, DispatcherType type) {
        return true;
    }
}
