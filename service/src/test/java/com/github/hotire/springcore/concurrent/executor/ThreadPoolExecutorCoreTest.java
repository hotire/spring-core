package com.github.hotire.springcore.concurrent.executor;

import com.github.hotire.springcore.test.ThreadUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class ThreadPoolExecutorCoreTest {

    @Test
    void callerRunsPolicy() {
        final ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1));
        executor.setRejectedExecutionHandler(new CallerRunsPolicy());

        log.info("start");
        IntStream.rangeClosed(0, 10).forEach(it -> executor.execute(() -> {
            log.info("callerRunsPolicy : {}", it);
            ThreadUtils.sleep(1000L);
        }));
        log.info("end");
    }

    @Test
    void takeLinkedBlockingQueue() {
        final ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1));
        executor.execute(() -> {
            ThreadUtils.sleep(1000L);
            log.info("blocking");
        });
        executor.execute(() -> {
            ThreadUtils.sleep(1000L);
            log.info("blocking");
        });
        ThreadUtils.sleep(30000L);
    }
}