package com.kakao.hotire.springcore.property;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(ConstructorBindingProperties.class)
@Configuration
public class PropertiesConfig {
}
