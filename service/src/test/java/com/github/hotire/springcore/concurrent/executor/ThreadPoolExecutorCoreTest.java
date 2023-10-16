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

    private static class Task implements Runnable {

        private final String name;
        private final long time;

        Task(String name, long time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public void run() {
            System.out.println("Run " + Thread.currentThread().getName() + "-" + name);
            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Finish " + Thread.currentThread().getName() + "-" + name);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private static void print(ThreadPoolExecutor tpe, String name) {
        System.out.println("After " + name + " execute -  pool size= " + tpe.getPoolSize() + ", queue=" + tpe.getQueue());
    }

    /**
     * https://stackoverflow.com/questions/12236694/how-does-maximumpoolsize-of-threadpoolexecutor-works/38615877#38615877
     */
    @Test
    void testKeepAlive() throws InterruptedException {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(
            1, 2, 500, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1));
        System.out.println("init pool size= " + tpe.getPoolSize() + ", queue size=" + tpe.getQueue().size());

        tpe.execute(new Task("1st", 10000));
        Thread.sleep(1000);
        print(tpe, "1st");

        tpe.execute(new Task("2nd", 100));
        Thread.sleep(1000);
        print(tpe, "2nd");

        tpe.execute(new Task("3d", 2000));
        Thread.sleep(1000);
        print(tpe, "3d");

        while (tpe.getPoolSize()>1) {
            Thread.sleep(100);
        }
        System.out.println("pool size= " + tpe.getPoolSize() + ", queue size=" + tpe.getQueue().size());
        tpe.shutdown();
    }


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