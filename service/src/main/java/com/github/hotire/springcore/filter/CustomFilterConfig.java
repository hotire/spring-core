package com.github.hotire.springcore.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class CustomFilterConfig {

    public static class FilterService {

    }

    public static class LoggingFilter implements Filter {

        @Autowired
        private FilterService filterService;

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            log.info("LoggingFilter");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Bean
    public FilterRegistrationBean<LoggingFilter> filterRegistrationBean() {
        final FilterRegistrationBean<LoggingFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(loggingFilter());
        bean.setUrlPatterns(List.of("*"));
        return bean;
    }

    @Bean
    public LoggingFilter loggingFilter() {
        return new LoggingFilter();
    }

    @Bean
    public FilterService filterService() {
        return new FilterService();
    }

}
