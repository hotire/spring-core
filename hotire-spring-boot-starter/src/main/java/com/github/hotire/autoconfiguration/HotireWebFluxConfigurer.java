package com.github.hotire.autoconfiguration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Slf4j
@RequiredArgsConstructor
public class HotireWebFluxConfigurer implements WebFluxConfigurer, InitializingBean {

    private final HotireProperties properties;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("init HotireWebFluxConfigurer message : {}", properties.getInitMessage());
    }
}
