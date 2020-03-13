package com.kakao.hotire.springcore.argument;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class HandlerMethodArgumentResolverConfig implements WebMvcConfigurer {

    @Bean
    public EntityArgumentResolver entityArgumentResolver() {
        return new EntityArgumentResolver();
    }

    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(entityArgumentResolver());
    }
}
