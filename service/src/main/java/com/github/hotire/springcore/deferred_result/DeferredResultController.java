package com.github.hotire.springcore.deferred_result;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("/deferred-result")
@RequiredArgsConstructor
public class DeferredResultController {

    private final DeferredResultContainer container;

    @GetMapping
    public DeferredResult<String> deferredResult(@RequestParam String id, @RequestParam Long timeout) {
        return container.get(container.createId("hello"), timeout, "Timeout");
    }

    @GetMapping("/publish")
    public void publish(@RequestParam String id, @RequestParam String value) {
        container.publish(container.createId("hello"), value);
    }
}
