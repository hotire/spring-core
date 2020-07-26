package com.github.hotire.autoconfiguration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@ConditionalOnClass(WebFluxConfigurer.class)
@EnableConfigurationProperties(HotireProperties.class)
public class HotireAutoConfiguration {

    @Bean
    public HotireWebFluxConfigurer hotireWebFluxConfigurer(final HotireProperties properties) {
        return new HotireWebFluxConfigurer(properties);
    }
}
