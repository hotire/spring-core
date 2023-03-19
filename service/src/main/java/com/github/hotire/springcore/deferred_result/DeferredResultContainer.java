package com.github.hotire.springcore.deferred_result;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.context.request.async.DeferredResult;

@RequiredArgsConstructor
public class DeferredResultContainer {
    private final Map<DeferredResultId, DeferredResult<Object>> resultCache = new ConcurrentHashMap<>();

    @Data
    @RequiredArgsConstructor
    static class DeferredResultId {
        private final String value;
    }

    public DeferredResultId createId(String value) {
        return new DeferredResultId(value);
    }

    @SuppressWarnings("unchecked")
    public <T> DeferredResult<T> get(final DeferredResultId id) {
        resultCache.computeIfAbsent(id, deferredResultId -> {
            final DeferredResult<T> deferredResult = new DeferredResult<>();
            return (DeferredResult<Object>) deferredResult;
        });
        return (DeferredResult<T>) resultCache.get(id);
    }

    public <T> void publish(final DeferredResultId id,  final T result) {
        resultCache.computeIfPresent(id, (deferredResultId, objectDeferredResult) -> {
            objectDeferredResult.setResult(result);
            return null;
        });
    }

}
