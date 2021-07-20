package com.github.hotire.springcore.argument;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HandlerMethodArgumentResolverConfig implements WebMvcConfigurer {

    @Bean
    public com.github.hotire.springcore.argument.EntityArgumentResolver entityArgumentResolver() {
        return new EntityArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(entityArgumentResolver());
    }
}
