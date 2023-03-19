package com.github.hotire.springcore.deferred_result;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.web.context.request.async.DeferredResult;

@RequiredArgsConstructor
public class DeferredResultContainer {
    private final Map<DeferredResultId, DeferredResult<Object>> resultCache = new ConcurrentHashMap<>();

    @RequiredArgsConstructor
    static class DeferredResultId {
        private final String value;
    }

    public DeferredResultId createId(String value) {
        return new DeferredResultId(value);
    }

    public <T> DeferredResult<T> of(final DeferredResultId id) {
        final DeferredResult<T> deferredResult = new DeferredResult<>();
        return deferredResult;
    }

    public <T> void publish(final DeferredResultId id,  final T result) {
        resultCache.computeIfPresent(id, (deferredResultId, objectDeferredResult) -> {
            objectDeferredResult.setResult(result);
            return null;
        });
    }

}
