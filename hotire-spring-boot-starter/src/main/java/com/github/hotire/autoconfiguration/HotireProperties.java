package com.github.hotire.autoconfiguration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "hotire.webflux")
public class HotireProperties {
    private boolean enabled;
    private String initMessage;
}
