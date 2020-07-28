package com.github.hotire.autoconfiguration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "hotire.webflux", value = "enabled", matchIfMissing = true)
@EnableConfigurationProperties(HotireProperties.class)
public class HotireAutoConfiguration {

    @Bean
    public HotireService hotireService(final HotireProperties properties) {
        return new HotireService(properties);
    }
}
