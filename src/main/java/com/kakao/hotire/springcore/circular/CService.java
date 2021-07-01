package com.kakao.hotire.springcore.circular;

import org.springframework.stereotype.Component;

@Component
public class CService {
    private final BService bService;

    public CService(final BService bService) {
        this.bService = bService;
    }
}
