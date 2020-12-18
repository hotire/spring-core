package com.github.hotire.autoconfiguration;

import org.springframework.beans.factory.InitializingBean;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CustomService implements InitializingBean {

    private final CustomProperties properties;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("init HotireWebFluxConfigurer message : {}", properties.getInitMessage());
    }
}
