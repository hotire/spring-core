package com.github.hotire.springcore.deferred_result;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.web.context.request.async.DeferredResult;

@RequiredArgsConstructor
public class DeferredResultContainer {
    private final Map<DeferredResultId, DeferredResult<?>> resultCache = new ConcurrentHashMap<>();

    @RequiredArgsConstructor
    static class DeferredResultId {
        private final String value;
    }

}
