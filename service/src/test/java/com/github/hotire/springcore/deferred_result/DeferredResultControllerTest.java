package com.github.hotire.springcore.deferred_result;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

class DeferredResultControllerTest {

    @Test
    void fireAndForget() throws InterruptedException {
        final WebClient client = WebClient.create("http://localhost:8080");

        client
            .get()
            .uri("/deferred-result?id=3&&timeout=10000")
            .retrieve()
            .bodyToMono(String.class)
            .log()
            .subscribe(System.out::println);

        Thread.sleep(1000L);
    }

}