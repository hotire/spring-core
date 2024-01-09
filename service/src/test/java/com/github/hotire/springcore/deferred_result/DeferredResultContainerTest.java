package com.github.hotire.springcore.deferred_result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.github.hotire.springcore.deferred_result.example.DeferredResultContainer;
import com.github.hotire.springcore.deferred_result.example.DeferredResultContainer.DeferredResultId;
import org.junit.jupiter.api.Test;
import org.springframework.web.context.request.async.DeferredResult;

class DeferredResultContainerTest {

    @Test
    void publish() {
        // given
        final DeferredResultContainer container = new DeferredResultContainer();
        final DeferredResultId id = container.createId("abc");
        final Long timeout = 100L;
        final String timeoutResult = "timeout";
        final DeferredResult<String> deferredResult = container.get(id, timeout, timeoutResult);
        final String result = "result";

        // when
        container.publish(id, result);

        // then
        assertThat(deferredResult.getResult()).isEqualTo(result);
    }

}