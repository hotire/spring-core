package com.github.hotire.springcore.deferred_result;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeferredResultContainer {
    private final Map<DeferredResultId, DeferredResult<Object>> resultCache = new ConcurrentHashMap<>();

    public Set<DeferredResultId> getResultCacheIds() {
        return resultCache.keySet();
    }

    @Data
    @RequiredArgsConstructor
    static class DeferredResultId {
        private final String value;
    }

    public DeferredResultId createId(String value) {
        return new DeferredResultId(value);
    }

    @SuppressWarnings("unchecked")
    public <T> DeferredResult<T> get(final DeferredResultId id, final Long timeout, final Object timeoutResult) {
        return (DeferredResult<T>) resultCache.computeIfAbsent(id, deferredResultId -> {
            final DeferredResult<T> deferredResult = new DeferredResult<>(timeout, timeoutResult);
            deferredResult.onCompletion(() -> {
                log.info("[DeferredResultContainer] onCompletion");
                resultCache.remove(id);
            });
            deferredResult.onTimeout(() -> {
                log.warn("[DeferredResultContainer] onTimeout");
                resultCache.remove(id);
            });
            deferredResult.onError(error -> {
                log.error("[DeferredResultContainer] onError message: {}", error.getMessage(), error);
                resultCache.remove(id);
            });
            return (DeferredResult<Object>) deferredResult;
        });
    }

    public <T> void publish(final DeferredResultId id,  final T result) {
        resultCache.computeIfPresent(id, (deferredResultId, objectDeferredResult) -> {
            objectDeferredResult.setResult(result);
            resultCache.remove(id);
            return null;
        });
    }

}
