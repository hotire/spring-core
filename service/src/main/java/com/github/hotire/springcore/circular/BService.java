package com.github.hotire.springcore.circular;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BService {
//    @Autowired
// if autowired is enabled, The dependencies of some of the beans in the application context form a cycle:

    private AService aService;

    public BService() {
        log.info("BService");
    }
}
