package com.github.hotire.autoconfiguration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "custom.webflux", value = "enabled", matchIfMissing = true)
@EnableConfigurationProperties(CustomProperties.class)
public class CustomAutoConfiguration {

    @Bean
    public CustomService hotireService(final CustomProperties properties) {
        return new CustomService(properties);
    }
}
