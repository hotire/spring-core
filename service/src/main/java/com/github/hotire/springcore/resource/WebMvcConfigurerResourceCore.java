package com.github.hotire.springcore.resource;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfigurerResourceCore implements WebMvcConfigurer {

    /**
     * @see WebMvcConfigurer#addResourceHandlers(ResourceHandlerRegistry) 
     * @see org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration#addResourceHandlers(ResourceHandlerRegistry) 
     * @see org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter#addResourceHandlers(ResourceHandlerRegistry) 
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("").addResourceLocations("");
    }
}
