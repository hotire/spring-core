package com.github.hotire.autoconfiguration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "hotire.webflux")
public class HotireProperties {
    private boolean enabled;
    private String initMessage;
}
