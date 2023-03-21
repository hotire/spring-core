package com.github.hotire.springcore.filter;

import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.RequestPath;
import org.springframework.web.util.ServletRequestPathUtils;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

@Slf4j
@Configuration
public class CustomFilterConfig {

    @RequiredArgsConstructor
    public static class LoggingFilter implements Filter {

        private final List<PathPattern> pathPatterns;

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            log.info("LoggingFilter");
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            log.info(httpServletRequest.getRequestURI());
            log.info(httpServletRequest.getServletPath());
            log.info(httpServletRequest.getPathInfo());

            RequestPath path = ServletRequestPathUtils.parseAndCache(httpServletRequest);
            final Boolean match = pathPatterns.stream().anyMatch(it -> it.matches(path));
            log.info("RequestPath match : {}", match);
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
        return new LoggingFilter(List.of(PathPatternParser.defaultInstance.parse("/deferred-result/**")));
    }
}
