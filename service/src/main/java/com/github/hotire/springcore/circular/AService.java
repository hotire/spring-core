package com.github.hotire.springcore.circular;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AService {
    private final BService bService;

    public AService(final BService bService) {
        log.info("AService");
        this.bService = bService;
    }
}
