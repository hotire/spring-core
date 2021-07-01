package com.kakao.hotire.springcore.circular;

import org.springframework.stereotype.Component;

@Component
public class AService {
    private final CService cService;

    public AService(final CService cService) {
        this.cService = cService;
    }
}
