package com.github.hotire.springcore.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class LazyService {

    private final LazyCore lazyCore;

    public LazyService(@Lazy LazyCore lazyCore) {
        this.lazyCore = lazyCore;
    }
}
