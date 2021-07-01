package com.kakao.hotire.springcore.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BService {
    @Autowired
    private AService aService;

    public BService() {
        log.info("BService");
    }
}
