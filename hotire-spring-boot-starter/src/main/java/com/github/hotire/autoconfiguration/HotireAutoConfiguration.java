package com.github.hotire.autoconfiguration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HotireProperties.class)
public class HotireAutoConfiguration {
}
