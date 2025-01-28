package com.github.hotire.autoconfiguration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
//@Configuration
public class CustomAutoConfigurationAfter2_7_0 {

    @PostConstruct
    public void init() {
        log.info("[CustomAutoConfigurationAfter2_7_0]");
    }


}
