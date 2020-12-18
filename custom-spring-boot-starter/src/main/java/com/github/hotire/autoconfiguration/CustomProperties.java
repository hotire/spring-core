package com.github.hotire.autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "custom.webflux")
public class CustomProperties {
    private boolean enabled;
    private String initMessage;
}
