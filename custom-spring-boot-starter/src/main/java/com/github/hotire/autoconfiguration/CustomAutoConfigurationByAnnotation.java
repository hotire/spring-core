package com.github.hotire.autoconfiguration;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;

@Slf4j
@AutoConfiguration
public class CustomAutoConfigurationByAnnotation {

    @PostConstruct
    public void init() {
        log.info("[CustomAutoConfigurationAfter2_7_0]");
    }

}
