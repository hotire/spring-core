package com.github.hotire.springcore.deferred_result;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.github.hotire.springcore.deferred_result.DeferredResultContainer.DeferredResultId;
import org.junit.jupiter.api.Test;
import org.springframework.web.context.request.async.DeferredResult;

class DeferredResultContainerTest {

    @Test
    void publish() {
        // given
        final DeferredResultContainer container = new DeferredResultContainer();
        final DeferredResultId id = container.createId("abc");
        final DeferredResult<String> deferredResult = container.get(id);
        final String result = "result";

        // when
        container.publish(id, result);

        // then
        assertThat(deferredResult.getResult()).isEqualTo(result);
    }

}