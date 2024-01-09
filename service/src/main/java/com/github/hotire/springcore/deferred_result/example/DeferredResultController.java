package com.github.hotire.springcore.deferred_result.example;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/deferred-result")
@RequiredArgsConstructor
public class DeferredResultController {

    private final DeferredResultContainer container;

    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping
    public DeferredResult<String> deferredResult() {
        return container.get(container.createId(String.valueOf(counter.getAndIncrement())), 10000L, "Timeout");
    }

    @GetMapping("/{id}")
    public DeferredResult<String> deferredResult(@PathVariable String id, @RequestParam Long timeout) {
        return container.get(container.createId(id), timeout, "Timeout");
    }


    @GetMapping("/publish")
    public void publish(@RequestParam String id, @RequestParam String value) {
        container.publish(container.createId(id), value);
    }

    @GetMapping("/publish-error")
    public void publish(@RequestParam String id) {
        container.get(container.createId(id), 10000L, "Timeout").setErrorResult(new RuntimeException("hello error"));
    }
}
