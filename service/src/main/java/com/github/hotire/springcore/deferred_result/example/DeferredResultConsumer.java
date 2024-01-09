package com.github.hotire.springcore.deferred_result.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeferredResultConsumer {

    private final DeferredResultContainer container;

//    @Scheduled(fixedDelay = 500)
    public void consume() {
        log.info("[DeferredResultConsumer] consume");
        container.getResultCacheIds().forEach(id -> {
            container.publish(id, "result");
        });
    }
}
